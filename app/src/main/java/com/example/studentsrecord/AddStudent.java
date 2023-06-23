package com.example.studentsrecord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.studentsrecord.data.DBhandler;
import com.example.studentsrecord.data.Student;

public class AddStudent extends AppCompatActivity {

    EditText id, name,surah, para, ayat_start, ayat_end, sabqi, manzil, stClass,age;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        id= (EditText) findViewById(R.id.studentID);
        name= (EditText) findViewById(R.id.name);
        surah= (EditText)findViewById(R.id.surah);
        para= (EditText)findViewById(R.id.para);
        ayat_start= (EditText)findViewById(R.id.ayatStart);
        ayat_end= (EditText)findViewById(R.id.ayatEnd);
        sabqi= (EditText)findViewById(R.id.sabqi);
        manzil= (EditText)findViewById(R.id.manzil);
        stClass=(EditText)findViewById(R.id._class);
        age = (EditText)findViewById(R.id.age);

        btn = findViewById(R.id.addButton);
        DBhandler db= new DBhandler(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(id.getText().toString(), name.getText().toString(),Integer.parseInt(age.getText().toString()),Integer.parseInt(stClass.getText().toString()),Integer.parseInt(surah.getText().toString()),Integer.parseInt(para.getText().toString()),Integer.parseInt(ayat_start.getText().toString()), Integer.parseInt(ayat_end.getText().toString()),Integer.parseInt(manzil.getText().toString()));
                int result = db.insertStudent(student);

                if(result==-1)
                {
                    Toast.makeText(getApplicationContext(), "Couldn't add student!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Student added!", Toast.LENGTH_LONG).show();
                }

                // just a checker
                db.showdb();
                Intent intent = new Intent(AddStudent.this, SelectAction.class);
                startActivity(intent);


            }
        });
    }
}