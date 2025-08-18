package br.edu.utfpr.luancoelho.warplan;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamSubjectActivity extends AppCompatActivity {

    private Spinner spinnerExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);

        spinnerExam = findViewById(R.id.spinnerExam);

        populateSpinnerAreaOfKnowledge();
    }

    public void populateSpinnerAreaOfKnowledge() {
        String[] exams = getResources().getStringArray(R.array.exams_names);

        List<String> list = new ArrayList<>(Arrays.asList(exams));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerExam.setAdapter(adapter);
        spinnerExam.setSelection(0);
    }

    public void save(View view) {

    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        showToast("Campos limpos");
    }

}