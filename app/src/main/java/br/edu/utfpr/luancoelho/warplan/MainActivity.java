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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupDifficulty;
    private CheckBox checkBoxPriority;
    private Spinner spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextName.requestFocus();

        radioGroupDifficulty = findViewById(R.id.radioGroupDifficulty);
        radioGroupDifficulty.check(R.id.radioButtonEasy);
        checkBoxPriority = findViewById(R.id.checkBoxPriority);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        populateSpinner();
    }

    public void populateSpinner() {
        List<String> list = new ArrayList<>(List.of("Português", "Matemática", "Ciências"));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        spinnerCategory.setAdapter(adapter);
    }

    public void save(View view) {
        String name = editTextName.getText().toString();

        if (name.trim().isEmpty()) {
            showToast("Informe um nome");
            return;
        }

        // Exibe toast com o nome digitado e valor da média
        showToast("Nome: " + name);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        editTextName.setText(null);
        editTextName.requestFocus();
        radioGroupDifficulty.check(R.id.radioButtonEasy);
        spinnerCategory.setSelection(0);
        checkBoxPriority.setChecked(false);
    }

}