package com.example.uravnenie2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class second extends AppCompatActivity {
    private Button Exit2, Start, Teoria, Static;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addListernerOnButton();
   }
    public void addListernerOnButton(){
        Exit2 = (Button)findViewById(R.id.Exit2);
        Start = (Button) findViewById(R.id.Start);
        Teoria = (Button)findViewById(R.id.Teoria);
        Static = (Button)findViewById(R.id.Stat);
        Static.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Static");
                        startActivity(intent);
                    }
                }
        );
        Start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".ChoiceSubject");
                        startActivity(intent);
                    }
                }
        );
        Teoria.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".Teoria");
                        startActivity(intent);
                    }
                }
        );
        Exit2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(second.this);
                        a_builder.setMessage("Хотите выйти?")
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        finishAffinity();//закрытие программы
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        dialogInterface.cancel();//закрытие окна диалогового
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Выход");
                        alert.show();
                    }
                }
        );
    }
}