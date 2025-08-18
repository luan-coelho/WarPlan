package br.edu.utfpr.luancoelho.warplan;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamSubjectActivity extends AppCompatActivity {

    private Spinner spinnerExam;
    private Spinner spinnerSubject;
    private EditText editTextWeight;
    private Spinner spinnerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);

        spinnerExam = findViewById(R.id.spinnerExam);
        spinnerSubject = findViewById(R.id.spinnerSubject);
        editTextWeight = findViewById(R.id.editTextWeight);
        spinnerPriority = findViewById(R.id.spinnerPriority);

        populateSpinnerExams();
        populateSpinnerSubjects();
        populateSpinnerPriorities();
    }

    public void populateSpinnerExams() {
        String[] exams = getResources().getStringArray(R.array.exams_names);

        List<String> list = new ArrayList<>(Arrays.asList(exams));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerExam.setAdapter(adapter);
        spinnerExam.setSelection(0);
    }

    public void populateSpinnerSubjects() {
        String[] subjects = getResources().getStringArray(R.array.subjects_names);

        List<String> list = new ArrayList<>(Arrays.asList(subjects));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerSubject.setAdapter(adapter);
        spinnerSubject.setSelection(0);
    }

    public void populateSpinnerPriorities() {
        String[] priorities = getResources().getStringArray(R.array.priorities_names);

        List<String> list = new ArrayList<>(Arrays.asList(priorities));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerPriority.setAdapter(adapter);
    }

    public void save(View view) {
        if (spinnerExam.getSelectedItemPosition() == 0) {
            showToast("Informe o concurso");
            return;
        }

        if (spinnerSubject.getSelectedItemPosition() == 0) {
            showToast("Informe a matéria");
            return;
        }

        if (editTextWeight.getText().toString().trim().isEmpty()) {
            showToast("Informe o peso");
            return;
        }

        if (spinnerPriority.getSelectedItemPosition() == 0) {
            showToast("Informe a prioridade");
            return;
        }

        String exam = spinnerExam.getSelectedItem().toString();
        String subject = spinnerSubject.getSelectedItem().toString();
        String weight = editTextWeight.getText().toString();
        String priority = spinnerPriority.getSelectedItem().toString();

        showToast("Concurso: " + exam + "\nMatéria: " + subject + "\nPeso: " + weight + "\nPrioridade: " + priority);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        spinnerExam.setSelection(0);
        spinnerSubject.setSelection(0);
        editTextWeight.setText(null);
        spinnerPriority.setSelection(0);
        showToast("Campos limpos");
    }

}