package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.time.format.DateTimeFormatter;

import br.edu.utfpr.luancoelho.warplan.entity.Exam;

public class ExamDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_EXAM_ID = "EXTRA_EXAM_ID";
    public static final String EXTRA_EXAM_NAME = "EXTRA_EXAM_NAME";
    public static final String EXTRA_EXAM_DESCRIPTION = "EXTRA_EXAM_DESCRIPTION";
    public static final String EXTRA_EXAM_DATE = "EXTRA_EXAM_DATE";

    private TextView textViewExamName;
    private TextView textViewExamDescription;
    private TextView textViewExamDate;
    private MaterialButton buttonViewSubjects;
    private MaterialButton buttonAddSubject;

    private String examName;
    private String examDescription;
    private String examDate;
    private Long examId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_details);

        // Habilitar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Inicializar views
        initViews();

        // Receber dados do Intent
        receiveIntentData();

        // Configurar dados na interface
        setupExamData();

        // Configurar listeners dos botões
        setupButtonListeners();
    }

    private void initViews() {
        textViewExamName = findViewById(R.id.textViewExamName);
        textViewExamDescription = findViewById(R.id.textViewExamDescription);
        textViewExamDate = findViewById(R.id.textViewExamDate);
        buttonViewSubjects = findViewById(R.id.buttonViewSubjects);
        buttonAddSubject = findViewById(R.id.buttonAddSubject);
    }

    private void receiveIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            examId = intent.getLongExtra(EXTRA_EXAM_ID, -1);
            examName = intent.getStringExtra(EXTRA_EXAM_NAME);
            examDescription = intent.getStringExtra(EXTRA_EXAM_DESCRIPTION);
            examDate = intent.getStringExtra(EXTRA_EXAM_DATE);
        }
    }

    private void setupExamData() {
        if (examName != null) {
            textViewExamName.setText(examName);
        }

        if (examDescription != null) {
            textViewExamDescription.setText(examDescription);
        }

        if (examDate != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    java.time.LocalDate date = java.time.LocalDate.parse(examDate);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    textViewExamDate.setText(date.format(formatter));
                } catch (Exception e) {
                    textViewExamDate.setText(examDate);
                }
            } else {
                textViewExamDate.setText(examDate);
            }
        }
    }

    private void setupButtonListeners() {
        buttonViewSubjects.setOnClickListener(v -> openExamSubjectsActivity());
        buttonAddSubject.setOnClickListener(v -> openCreateExamSubjectActivity());
    }

    private void openExamSubjectsActivity() {
        Intent intent = new Intent(this, ExamSubjectActivity.class);
        intent.putExtra("EXAM_ID", examId);
        intent.putExtra("EXAM_NAME", examName);
        startActivity(intent);
    }

    private void openCreateExamSubjectActivity() {
        Intent intent = new Intent(this, CreateExamSubjectActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Método estático para facilitar a criação de Intent para esta activity
    public static Intent createIntent(android.content.Context context, Exam exam) {
        Intent intent = new Intent(context, ExamDetailsActivity.class);
        intent.putExtra(EXTRA_EXAM_ID, exam.getId());
        intent.putExtra(EXTRA_EXAM_NAME, exam.getName());
        intent.putExtra(EXTRA_EXAM_DESCRIPTION, exam.getDescription());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && exam.getDate() != null) {
            intent.putExtra(EXTRA_EXAM_DATE, exam.getDate().toString());
        }

        return intent;
    }
}
