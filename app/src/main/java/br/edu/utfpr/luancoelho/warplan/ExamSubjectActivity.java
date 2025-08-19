package br.edu.utfpr.luancoelho.warplan;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.luancoelho.warplan.adapter.ExamSubjectAdapter;
import br.edu.utfpr.luancoelho.warplan.entity.Exam;
import br.edu.utfpr.luancoelho.warplan.entity.ExamSubject;
import br.edu.utfpr.luancoelho.warplan.entity.Priority;
import br.edu.utfpr.luancoelho.warplan.entity.Subject;

public class ExamSubjectActivity extends AppCompatActivity {

    private ListView subjectExamListView;
    private List<ExamSubject> examSubjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_subject);

        subjectExamListView = findViewById(R.id.listViewExamSubject);
        subjectExamListView.setOnItemClickListener((parent, view, position, id) -> {
            ExamSubject examSubject = (ExamSubject) parent.getItemAtPosition(position);
            showToast(getString(R.string.exam_clicked, examSubject.getExam().getName()));
        });

        subjectExamListView.setOnItemLongClickListener((parent, view, position, id) -> {
            ExamSubject examSubject = (ExamSubject) parent.getItemAtPosition(position);
            showToast(getString(R.string.exam_long_clicked, examSubject.getExam().getName()));
            return true;
        });

        populateExamSubjectList();
        populateListView();
    }

    private void populateExamSubjectList() {
        this.examSubjectList = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String[] examNames = getResources().getStringArray(R.array.exam_names_list);
            String[] examDescriptions = getResources().getStringArray(R.array.exam_descriptions_list);
            String[] subjectNames = getResources().getStringArray(R.array.subject_names_list);

            Exam exam1 = new Exam(1L, examNames[3], examDescriptions[1], LocalDate.now());
            Exam exam2 = new Exam(2L, examNames[1], examDescriptions[2], LocalDate.now());
            Exam exam3 = new Exam(3L, examNames[2], examDescriptions[3], LocalDate.now());
            Exam exam4 = new Exam(4L, examNames[3], examDescriptions[4], LocalDate.now());
            Exam exam5 = new Exam(5L, examNames[4], examDescriptions[2], LocalDate.now());

            Subject subject1 = new Subject(1L, subjectNames[2]);
            Subject subject2 = new Subject(2L, subjectNames[1]);
            Subject subject3 = new Subject(3L, subjectNames[2]);
            Subject subject4 = new Subject(4L, subjectNames[3]);

            ExamSubject examSubject1 = new ExamSubject(1L, exam1, subject1, 10.0, Priority.HIGH);
            ExamSubject examSubject2 = new ExamSubject(2L, exam2, subject2, 20.0, Priority.MEDIUM);
            ExamSubject examSubject3 = new ExamSubject(3L, exam3, subject3, 30.0, Priority.LOW);
            ExamSubject examSubject4 = new ExamSubject(4L, exam4, subject4, 40.0, Priority.HIGH);
            ExamSubject examSubject5 = new ExamSubject(5L, exam5, subject1, 50.0, Priority.MEDIUM);

            List<ExamSubject> collection = List.of(
                    examSubject1,
                    examSubject2,
                    examSubject3,
                    examSubject4,
                    examSubject5
            );
            this.examSubjectList.addAll(collection);
        }
    }

    private void populateListView() {
        ExamSubjectAdapter examSubjectAdapter = new ExamSubjectAdapter(this, examSubjectList);
        subjectExamListView.setAdapter(examSubjectAdapter);
    }

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

}