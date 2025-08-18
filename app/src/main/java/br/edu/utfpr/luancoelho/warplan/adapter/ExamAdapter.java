package br.edu.utfpr.luancoelho.warplan.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import br.edu.utfpr.luancoelho.warplan.R;
import br.edu.utfpr.luancoelho.warplan.entity.Exam;

public class ExamAdapter extends BaseAdapter {

    private Context context;
    private List<Exam> examList;

    private static class ExamViewHolder {
        TextView textViewExamNameValue;
        TextView textViewExamDescriptionValue;
        TextView textViewExamDateValue;
    }

    public ExamAdapter() {

    }

    public ExamAdapter(Context context, List<Exam> examList) {
        this.context = context;
        this.examList = examList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @Override
    public int getCount() {
        return this.examList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.examList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExamViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_line_exams, parent, false);

            holder = new ExamViewHolder();

            holder.textViewExamNameValue = convertView
                    .findViewById(R.id.textViewExamNameValue);
            holder.textViewExamDescriptionValue = convertView
                    .findViewById(R.id.textViewExamDescriptionValue);
            holder.textViewExamDateValue = convertView
                    .findViewById(R.id.textViewExameDateValue);

            convertView.setTag(holder);
        } else {
            holder = (ExamViewHolder) convertView.getTag();
        }

        DateTimeFormatter formatter;

        Exam exam = examList.get(position);

        holder.textViewExamNameValue.setText(exam.getName());
        holder.textViewExamDescriptionValue.setText(exam.getDescription());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
            holder.textViewExamDateValue.setText(exam.getDate().format(formatter));
        }

        return convertView;
    }

}
