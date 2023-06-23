package com.example.studentsrecord.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsrecord.R;

import java.util.ArrayList;
import java.util.List;

public class StudentRVAdapter extends RecyclerView.Adapter<StudentRVAdapter.MyVH>{

    List<Student> students;

    public StudentRVAdapter(@NonNull ArrayList<Student> students)
    {
        this.students = students;

    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {


        holder.st = students.get(position);

        EditText id= holder.id;
        id.setText(holder.st.getId());

        EditText name= holder.name;
        name.setText(holder.st.getName());

        EditText age= holder.age;
        age.setText(holder.st.getAge());

        EditText Stclass=holder.stClass;
        Stclass.setText(holder.st.get_Class());

        EditText surah = holder.surah;
        surah.setText(holder.st.getSurah());

        EditText para = holder.para;
        para.setText(holder.st.getPara());

        EditText ayat_start = holder.ayat_start;
        ayat_start.setText(holder.st.getStartVerse());

        EditText ayat_end = holder.ayat_end;
        ayat_end.setText(holder.st.getEndVerse());

        EditText sabqi = holder.sabqi;
        sabqi.setText(holder.st.getSabqi());

        EditText manzil = holder.manzil;
        manzil.setText(holder.st.getManzil());

        AppCompatButton btn = holder.btn;
        btn.setText("Update");
    }

    @Override
    public int getItemCount() {
        return students.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        public Student st;
        EditText id, name,surah, para, ayat_start, ayat_end, sabqi, manzil, stClass,age;
        AppCompatButton btn;


        public MyVH(@NonNull View itemView) {
            super(itemView);

            id= (EditText) itemView.findViewById(R.id.studentID2);
            name= (EditText) itemView.findViewById(R.id.name2);
            surah= (EditText) itemView.findViewById(R.id.surah2);
            para= (EditText) itemView.findViewById(R.id.para2);
            ayat_start= (EditText) itemView.findViewById(R.id.ayatStart2);
            ayat_end= (EditText) itemView.findViewById(R.id.ayatEnd2);
            sabqi= (EditText) itemView.findViewById(R.id.sabqi2);
            manzil= (EditText) itemView.findViewById(R.id.manzil2);
            stClass=(EditText) itemView.findViewById(R.id._class2);
            age=(EditText) itemView.findViewById(R.id.age2);
            btn = (AppCompatButton) itemView.findViewById(R.id.updateButton2);

        }
    }

    public interface OnItemClickListener{
        void onButtonClick(int position);
    }
}
