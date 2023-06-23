package com.example.studentsrecord;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsrecord.data.DBhandler;

public class StudentDetails extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        rv= (RecyclerView)findViewById(R.id.recyclerv);

        DBhandler db = new DBhandler(this);
      /*  ArrayList<Student> st= db.getStudent(id);

        StudentRVAdapter studentRVAdapter = new StudentRVAdapter(st);
        rv.setAdapter(studentRVAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
*/
    }
}