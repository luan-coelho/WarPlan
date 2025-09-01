package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

        MaterialCardView cardExams = findViewById(R.id.cardExams);
        MaterialCardView cardAbout = findViewById(R.id.cardAbout);

        cardExams.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ExamsActivity.class);
            startActivity(intent);
        });

        cardAbout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });
    }

}