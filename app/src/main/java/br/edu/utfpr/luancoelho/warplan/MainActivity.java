package br.edu.utfpr.luancoelho.warplan;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupDifficulty;
    private CheckBox checkBoxPriority;
    private Spinner spinnerAreaOfKnowledge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextWeight);
        editTextName.requestFocus();
        radioGroupDifficulty = findViewById(R.id.radioGroupDifficulty);
        checkBoxPriority = findViewById(R.id.checkBoxPriority);
        spinnerAreaOfKnowledge = findViewById(R.id.spinnerAreaOfKnowledge);

        populateSpinnerAreaOfKnowledge();
    }

    public void populateSpinnerAreaOfKnowledge() {
        String[] areasOfKnowledge = getResources().getStringArray(R.array.areas_of_knowledge);

        List<String> list = new ArrayList<>(Arrays.asList(areasOfKnowledge));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerAreaOfKnowledge.setAdapter(adapter);
        spinnerAreaOfKnowledge.setSelection(0);
    }

    public void save(View view) {
        String name = editTextName.getText().toString();

        if (name.trim().isEmpty()) {
            showToast("Informe um nome");
            return;
        }

        if (radioGroupDifficulty.getCheckedRadioButtonId() == -1) {
            showToast("Informe a dificuldade percebida");
            return;
        }

        if (spinnerAreaOfKnowledge.getSelectedItemPosition() == 0) {
            showToast("Informe a área de conhecimento");
            return;
        }

        String difficulty = getDifficulty();
        String areaOfKnowledge = spinnerAreaOfKnowledge.getSelectedItem().toString();
        boolean priority = checkBoxPriority.isChecked();
        showToast("Nome: " + name + "\nDificuldade: " + difficulty + "\nÁrea de conhecimento: " + areaOfKnowledge + "\nPrioridade: " + priority);
    }

    private String getDifficulty() {
        return radioGroupDifficulty.getCheckedRadioButtonId() == R.id.radioButtonEasy
                ? "Fácil"
                : "Difícil";
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        editTextName.setText(null);
        radioGroupDifficulty.clearCheck();
        spinnerAreaOfKnowledge.setSelection(0);
        checkBoxPriority.setChecked(false);

        editTextName.requestFocus();

        showToast("Campos limpos");
    }

}