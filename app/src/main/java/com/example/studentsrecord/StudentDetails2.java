package com.example.studentsrecord;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.studentsrecord.data.DBhandler;
import com.example.studentsrecord.data.Student;

public class StudentDetails2 extends AppCompatActivity {

    EditText Stid, name,surah, para, ayat_start, ayat_end, sabqi, manzil, stClass,age;
    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details2);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        System.out.println(id);
        DBhandler db = new DBhandler(this);
        Student student = db.getStudent(id);

        Stid= (EditText) findViewById(R.id.studentID3);
        name= (EditText) findViewById(R.id.name3);
        surah= (EditText)findViewById(R.id.surah3);
        para= (EditText)findViewById(R.id.para3);
        ayat_start= (EditText)findViewById(R.id.ayatStart3);
        ayat_end= (EditText)findViewById(R.id.ayatEnd3);
        sabqi= (EditText)findViewById(R.id.sabqi3);
        manzil= (EditText)findViewById(R.id.manzil3);
        stClass=(EditText)findViewById(R.id._class3);
        age = (EditText)findViewById(R.id.age3);

        btn = findViewById(R.id.addButton3);

        if(student!=null) {
            Stid.setText(student.getId());
            name.setText(student.getName());
            surah.setText(student.getSurah());
            para.setText(student.getPara());
            ayat_start.setText(student.getStartVerse());
            ayat_end.setText(student.getEndVerse());
            sabqi.setText(student.getSabqi());
            manzil.setText(student.getManzil());
            stClass.setText(student.get_Class());
            age.setText(student.getAge());
        }
        else {
            Toast.makeText(getApplicationContext(), "No Student found!", Toast.LENGTH_LONG).show();
        }


    }
}