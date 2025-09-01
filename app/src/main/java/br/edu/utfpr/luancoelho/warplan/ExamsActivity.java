package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.luancoelho.warplan.adapter.ExamAdapter;
import br.edu.utfpr.luancoelho.warplan.entity.Exam;

public class ExamsActivity extends AppCompatActivity {

    public static final String EXTRA_EXAM_NAME = "EXTRA_EXAM_NAME";
    public static final String EXTRA_EXAM_DESCRIPTION = "EXTRA_EXAM_DESCRIPTION";
    public static final String EXTRA_EXAM_DATE = "EXTRA_EXAM_DATE";

    private ListView listViewExams;
    private Button buttonCreateExam;
    private List<Exam> examList;

    private ActivityResultLauncher<Intent> createExamLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        setTitle(getString(R.string.exams_title));

        examList = new ArrayList<>();

        // Configurar ActivityResultLauncher
        createExamLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();

                        String examName = data.getStringExtra(ExamsActivity.EXTRA_EXAM_NAME);
                        String examDescription = data.getStringExtra(ExamsActivity.EXTRA_EXAM_DESCRIPTION);
                        String examDateStr = data.getStringExtra(ExamsActivity.EXTRA_EXAM_DATE);

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            LocalDate examDate = LocalDate.parse(examDateStr);
                            Exam newExam = new Exam(examName, examDescription, examDate);

                            examList.add(newExam);

                            showToast(getString(R.string.exam_created_success, examName));

                            populateListView();
                        }
                    }
                });

        // Habilitar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listViewExams = findViewById(R.id.listViewExams);
        buttonCreateExam = findViewById(R.id.buttonCreateExam);

        listViewExams.setOnItemClickListener((parent, view, position, id) -> {
            Exam exam = (Exam) parent.getItemAtPosition(position);
            openExamDetails(exam);
        });

        buttonCreateExam.setOnClickListener(v -> {
            Intent intent = CreateExamActivity.createIntent(this);
            createExamLauncher.launch(intent);
        });

        populateListView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Botão de voltar pressionado
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateListView() {
        ExamAdapter examAdapter = new ExamAdapter(this, examList);
        listViewExams.setAdapter(examAdapter);
    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    private void openExamDetails(Exam exam) {
        Intent intent = ExamDetailsActivity.createIntent(this, exam);
        startActivity(intent);
    }

}