package br.edu.utfpr.luancoelho.warplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.utfpr.luancoelho.warplan.R;
import br.edu.utfpr.luancoelho.warplan.entity.ExamSubject;

public class ExamSubjectAdapter extends BaseAdapter {

    private Context context;
    private List<ExamSubject> examSubjects;

    private static class ExamViewHolder {
        TextView textViewExamNameValue;
        TextView textViewSubjectValue;
        TextView textViewWeightValue;
        TextView textViewPriorityValue;
    }

    public ExamSubjectAdapter() {

    }

    public ExamSubjectAdapter(Context context, List<ExamSubject> examSubjects) {
        this.context = context;
        this.examSubjects = examSubjects;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.examSubjects.size();
    }

    @Override
    public Object getItem(int position) {
        return this.examSubjects.get(position);
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
            convertView = inflater.inflate(R.layout.list_line_exam_subject, parent, false);

            holder = new ExamViewHolder();

            holder.textViewExamNameValue = convertView
                    .findViewById(R.id.textViewExamNameValue);
            holder.textViewSubjectValue = convertView
                    .findViewById(R.id.textViewSubjectNameValue);
            holder.textViewWeightValue = convertView
                    .findViewById(R.id.textViewWeightValue);
            holder.textViewPriorityValue = convertView
                    .findViewById(R.id.textViewPriorityValue);

            convertView.setTag(holder);
        } else {
            holder = (ExamViewHolder) convertView.getTag();
        }

        ExamSubject examSubject = examSubjects.get(position);

        holder.textViewExamNameValue.setText(examSubject.getExam().getName());
        holder.textViewSubjectValue.setText(examSubject.getSubject().getName());
        holder.textViewWeightValue.setText(String.valueOf(examSubject.getWeight()));
        holder.textViewPriorityValue.setText(examSubject.getPriority().toString());

        return convertView;
    }

}
