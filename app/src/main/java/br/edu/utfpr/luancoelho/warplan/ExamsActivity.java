package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.luancoelho.warplan.adapter.ExamAdapter;
import br.edu.utfpr.luancoelho.warplan.entity.Exam;

public class ExamsActivity extends AppCompatActivity {

    private ListView listViewExams;
    private List<Exam> examList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        // Habilitar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        listViewExams = findViewById(R.id.listViewExams);
        listViewExams.setOnItemClickListener((parent, view, position, id) -> {
            Exam exam = (Exam) parent.getItemAtPosition(position);
            openExamDetails(exam);
        });

        populateExamList();
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

    private void populateExamList() {
        this.examList = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Exam exam1 = new Exam(1L, "Exame 1", "Descrição do exame 1", LocalDate.now());
            Exam exam2 = new Exam(2L, "Exame 2", "Descrição do exame 2", LocalDate.now());
            Exam exam3 = new Exam(3L, "Exame 3", "Descrição do exame 3", LocalDate.now());
            Exam exam4 = new Exam(4L, "Exame 4", "Descrição do exame 4", LocalDate.now());
            Exam exam5 = new Exam(5L, "Exame 5", "Descrição do exame 5", LocalDate.now());
            Exam exam6 = new Exam(6L, "Exame 6", "Descrição do exame 6", LocalDate.now());
            Exam exam7 = new Exam(7L, "Exame 7", "Descrição do exame 7", LocalDate.now());
            Exam exam8 = new Exam(8L, "Exame 8", "Descrição do exame 8", LocalDate.now());
            Exam exam9 = new Exam(9L, "Exame 9", "Descrição do exame 9", LocalDate.now());
            Exam exam10 = new Exam(10L, "Exame 10", "Descrição do exame 10", LocalDate.now());
            Exam exam11 = new Exam(11L, "Exame 11", "Descrição do exame 11", LocalDate.now());
            Exam exam12 = new Exam(12L, "Exame 12", "Descrição do exame 12", LocalDate.now());
            Exam exam13 = new Exam(13L, "Exame 13", "Descrição do exame 13", LocalDate.now());

            this.examList.addAll(List.of(exam1, exam2, exam3, exam4, exam5, exam6, exam7, exam8, exam9, exam10, exam11,
                    exam12, exam13));
        }
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