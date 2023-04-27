package com.example.uravnenie2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ChoiceSubject extends AppCompatActivity {

    private Button btn1subject, btn2subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_subject);
        addListernerOnButton();

    }

    public void addListernerOnButton(){
        btn1subject =  findViewById(R.id.btn1subject);
        btn2subject =  findViewById(R.id.btn2subject);
        btn1subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(".Start");
                startActivity(intent);
            }
        });
        btn2subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }


}
