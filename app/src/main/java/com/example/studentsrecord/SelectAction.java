package com.example.studentsrecord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SelectAction extends AppCompatActivity {

    AppCompatButton Addbtn;
    AppCompatButton ViewBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);

        Addbtn = (AppCompatButton) findViewById(R.id.button);
        ViewBtn = (AppCompatButton) findViewById(R.id.button2);

        Addbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAction.this, AddStudent.class);
                startActivity(intent);
            }
        });

        ViewBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAction.this,ViewStudent.class);
                startActivity(intent);
            }
        });




    }
}