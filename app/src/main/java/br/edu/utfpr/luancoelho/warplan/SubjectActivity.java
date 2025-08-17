package br.edu.utfpr.luancoelho.warplan;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectActivity extends AppCompatActivity {

    private ListView listViewSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        listViewSubjects = findViewById(R.id.listViewSubjects);

        populateListView();
    }

    private void populateListView() {

    }

}