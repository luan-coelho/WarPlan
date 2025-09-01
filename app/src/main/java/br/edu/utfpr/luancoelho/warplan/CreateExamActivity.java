package br.edu.utfpr.luancoelho.warplan;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class CreateExamActivity extends AppCompatActivity {

    private EditText editTextExamName;
    private EditText editTextExamDescription;
    private EditText editTextExamDate;
    private Button buttonSaveExam;

    private LocalDate selectedDate;
    private DateTimeFormatter dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exam);

        setTitle(getString(R.string.create_exam_title));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        initializeViews();
        setupDatePicker();
        setupClickListeners();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }
    }

    private void initializeViews() {
        editTextExamName = findViewById(R.id.editTextExamName);
        editTextExamDescription = findViewById(R.id.editTextExamDescription);
        editTextExamDate = findViewById(R.id.editTextExamDate);
        buttonSaveExam = findViewById(R.id.buttonSaveExam);
    }

    private void setupDatePicker() {
        editTextExamDate.setOnClickListener(v -> showDatePicker());
    }

    private void setupClickListeners() {
        buttonSaveExam.setOnClickListener(v -> saveExam());
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    selectedDate = LocalDate.of(year, month + 1, dayOfMonth);
                    editTextExamDate.setText(selectedDate.format(dateFormatter));
                } else {
                    // Para versões anteriores ao Android O
                    String dateString = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
                    editTextExamDate.setText(dateString);
                }
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    private void saveExam() {
        String examName = editTextExamName.getText().toString().trim();
        String examDescription = editTextExamDescription.getText().toString().trim();
        String examDateString = editTextExamDate.getText().toString().trim();

        if (examName.isEmpty()) {
            showToast(getString(R.string.error_exam_name_required));
            return;
        }

        if (examDescription.isEmpty()) {
            showToast(getString(R.string.error_exam_description_required));
            return;
        }

        if (examDateString.isEmpty()) {
            showToast(getString(R.string.error_exam_date_required));
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && selectedDate == null) {
            showToast(getString(R.string.error_exam_date_invalid));
            return;
        }

        showToast(getString(R.string.exam_saved_success, examName));

        Intent resultIntent = new Intent();
        resultIntent.putExtra(ExamsActivity.EXTRA_EXAM_NAME, examName);
        resultIntent.putExtra(ExamsActivity.EXTRA_EXAM_DESCRIPTION, examDescription);

        // Passar a data no formato ISO para que LocalDate.parse() funcione corretamente
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && selectedDate != null) {
            resultIntent.putExtra(ExamsActivity.EXTRA_EXAM_DATE, selectedDate.toString());
        } else {
            resultIntent.putExtra(ExamsActivity.EXTRA_EXAM_DATE, examDateString);
        }

        setResult(RESULT_OK, resultIntent);

        finish();
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent createIntent(android.content.Context context) {
        return new Intent(context, CreateExamActivity.class);
    }

}
