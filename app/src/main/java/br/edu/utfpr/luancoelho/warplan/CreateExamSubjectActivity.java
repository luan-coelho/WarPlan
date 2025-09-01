package br.edu.utfpr.luancoelho.warplan;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateExamSubjectActivity extends AppCompatActivity {

    private EditText editTextSubjectName;
    private EditText editTextSubjectDescription;
    private Button buttonSaveSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam_subject);

        // Habilitar botão de voltar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        editTextSubjectName = findViewById(R.id.editTextSubjectName);
        editTextSubjectDescription = findViewById(R.id.editTextSubjectDescription);
        buttonSaveSubject = findViewById(R.id.buttonSaveSubject);

        buttonSaveSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSubject();
            }
        });
    }

    private void saveSubject() {
        String subjectName = editTextSubjectName.getText().toString().trim();
        String subjectDescription = editTextSubjectDescription.getText().toString().trim();

        if (subjectName.isEmpty()) {
            showToast("Informe o nome da matéria");
            return;
        }

        if (subjectDescription.isEmpty()) {
            showToast("Informe a descrição da matéria");
            return;
        }

        showToast("Matéria salva: " + subjectName);
        
        // Limpar campos após salvar
        editTextSubjectName.setText("");
        editTextSubjectDescription.setText("");
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
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
