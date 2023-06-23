package com.example.studentsrecord;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class ViewStudent extends AppCompatActivity {

    EditText id;
    AppCompatButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);

        id= (EditText)findViewById(R.id.textView);
        btn= (AppCompatButton)findViewById(R.id.Viewbutton);

        String extra =id.toString();
        System.out.println(extra);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewStudent.this,StudentDetails2.class);
                intent.putExtra("id", extra);
                startActivity(intent);
            }
        });
    }
}