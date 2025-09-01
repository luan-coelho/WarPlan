package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExamSubjectActivity extends AppCompatActivity {

    private String examName;
    private Long examId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);

        // Habilitar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Receber dados do Intent
        receiveIntentData();

        // Configurar o texto de exibição
        TextView textViewExamSubject = findViewById(R.id.textViewExamSubject);
        if (examName != null) {
            textViewExamSubject.setText("Matérias do Concurso: " + examName);
        } else {
            textViewExamSubject.setText("Matérias do Concurso");
        }
    }

    private void receiveIntentData() {
        Intent intent = getIntent();
        if (intent != null) {
            examId = intent.getLongExtra("EXAM_ID", -1L);
            examName = intent.getStringExtra("EXAM_NAME");

            // Atualizar título da AppBar se tiver nome do concurso
            if (examName != null && getSupportActionBar() != null) {
                getSupportActionBar().setTitle("Matérias - " + examName);
            }
        }
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
}
