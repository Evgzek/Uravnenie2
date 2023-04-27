package com.example.uravnenie2;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button btn, Exit;//переменные
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//layout данной странницы запускается при переходе на нее
        addListernerOnButton();//метод обработки нажатий на кнопки
    }
    public void addListernerOnButton(){
        btn =  findViewById(R.id.btn);//id кнопки присваивается
        Exit = findViewById(R.id.Exit);
        btn.setOnClickListener(//действия при нажетие кнопки
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".second");//переход в главное меню
                        startActivity(intent);
                    }
                }
        );
        Exit.setOnClickListener(//выход
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Точно хочешь сдаться и не попробовать себя в чем то новом?")
                                //запуск диалогового окна
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        finish();//если нажимаете да то программа закрывается
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        dialogInterface.cancel();//если нет то диалоговое окно закрывается
                                    }
                                });
                        AlertDialog alert = a_builder.create();//создание
                        alert.setTitle("Выход");//название диалогового окна
                        alert.show();//представление
                    }
                }
        );
    }
}