package br.edu.utfpr.luancoelho.warplan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private MaterialCardView cardExams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar views
        cardExams = findViewById(R.id.cardExams);

        // Configurar click listener para o card de concursos
        cardExams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExamsActivity();
            }
        });
    }

    private void openExamsActivity() {
        Intent intent = new Intent(MainActivity.this, ExamsActivity.class);
        startActivity(intent);
    }
}