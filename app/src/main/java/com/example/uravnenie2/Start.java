package com.example.uravnenie2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
public class Start extends AppCompatActivity implements Perehod {
    private TextView text;
    private ImageView image;
    private Button A1, A2, A3, A4, try_again, contien, tema_2;
    public Button exit;
    public static double n = 0, s = 0;
    public static Integer s1 = 2;
    public static String ocenka1, datetime;
    static SharedPreferences sPref;
    public static final String SAVE_MASSIV = "save_massiv";
    public static ArrayList<String> dateList = new ArrayList<>();
    public Calendar c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }
    public void init() {
        text = findViewById(R.id.text);
        image = findViewById(R.id.image);
        contien = findViewById(R.id.btn_text);
        A1 = findViewById(R.id.A1);
        A2 = findViewById(R.id.A2);
        A3 = findViewById(R.id.A3);
        A4 = findViewById(R.id.A4);
        try_again = findViewById(R.id.try_again);
        exit = findViewById(R.id.exit);
        tema_2 = findViewById(R.id.btn2subject);
    }//метод для инициализации переменных
    public void Answer(Button A1, Button A2, Button A3, Button A4, int b) {
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Start.this, "Неверно", Toast.LENGTH_SHORT).show();
                text.setText(Constat.myStrok.get(b - 1));
                invisibleA();
                try_again.setVisibility(View.VISIBLE);
                if (b>1){
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Start.this, "Неверно", Toast.LENGTH_SHORT).show();
                text.setText(Constat.myStrok.get(b - 1));
                invisibleA();
                try_again.setVisibility(View.VISIBLE);
                if (b>1){
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Start.this, "Неверно", Toast.LENGTH_SHORT).show();
                text.setText(Constat.myStrok.get(b - 1));
                invisibleA();
                try_again.setVisibility(View.VISIBLE);
                if (b>1){
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
        A4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Start.this, "Верно, нажмите продолжить", Toast.LENGTH_SHORT).show();
                A4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                contien.setVisibility(View.VISIBLE);
                A1.setVisibility(View.INVISIBLE);
                A2.setVisibility(View.INVISIBLE);
                A3.setVisibility(View.INVISIBLE);
            }
        });
        try_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visibleA();
                try_again.setVisibility(View.INVISIBLE);
                image.setVisibility(View.INVISIBLE);
                text.setText(Constat.myStrok.get(b));
                n = nnn(n);
            }
        });
    }//работа с проверкой ответов и заносения параметра для статистики
    public void visibleA() {
        A1.setVisibility(View.VISIBLE);
        A2.setVisibility(View.VISIBLE);
        A3.setVisibility(View.VISIBLE);
        A4.setVisibility(View.VISIBLE);
    }//раскытие ответов
    public void invisibleA() {
        A1.setVisibility(View.INVISIBLE);
        A2.setVisibility(View.INVISIBLE);
        A3.setVisibility(View.INVISIBLE);
        A4.setVisibility(View.INVISIBLE);
    }//скрытие ответов
    public void setAnswer(int b) {
        A1.setText(Constat.ANSWER.get(b));
        A2.setText(Constat.ANSWER.get(b + 1));
        A3.setText(Constat.ANSWER.get(b + 2));
        A4.setText(Constat.ANSWER.get(b + 3));
    }//ответы
    public void neChet(int b, int a){
        text.setText(Constat.myStrok.get(a));
        image.setVisibility(View.INVISIBLE);
        visibleA();
        setAnswer(b);
        contien.setVisibility(View.INVISIBLE);
    }//практика
    public void chet(int b, int a, Button A){
        text.setText(Constat.myStrok.get(a));
        image.setVisibility(View.VISIBLE);
        image.setImageResource(Constat.myImages.get(b));
        invisibleA();
        A.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
    }//теория
    public double nnn(double n){
        n = n+1;
        return n;
    }//параметр для статистики
    @Override
    public void fgMain(int number) {
        if (number == 1) {
            neChet(0, number);
            Answer(A1, A2, A3, A4, number);
        } else if (number == 2) {
            chet(0, number, A4);
        } else if (number == 3) {
            neChet(4, number);
            Answer(A1, A4, A3, A2, number);
        } else if (number == 4) {
            chet(1, number, A2);
        } else if (number == 5) {
            neChet(8, number);
            Answer(A2, A4, A1, A3, number);
        } else if (number == 6) {
            chet(2, number, A3);
        } else if (number == 7) {
            neChet(12, number);
            Answer(A2, A4, A3, A1, number);
        } else if (number == 8) {
            chet(3, number, A1);
        } else if (number == 9) {
            neChet(16, number);
            Answer(A2, A4, A1, A3, number);
        } else if (number == 10) {
            chet(4, number, A3);
        } else if (number == 11) {
            neChet(20, number);
            Answer(A2, A3, A1, A4, number);
        } else if (number == 12) {
            chet(5, number, A4);
        } else if (number == 13) {
            neChet(24, number);
            Answer(A2, A3, A4, A1, number);
        } else if (number == 14) {
            chet(6, number, A1);
        } else if (number == 15) {
            neChet(28, number);
            Answer(A2, A1, A4, A3, number);
        } else if (number == 16) {
            chet(7, number, A3);
        } else if (number == 17) {
            neChet(32, number);
            Answer(A2, A3, A4, A1, number);
        } else if (number == 18) {
            chet(8, number, A1);
        } else if (number == 19) {
            neChet(36, number);
            Answer(A2, A3, A1, A4, number);
        } else if (number == 20) {
            chet(9, number, A4);
        } else if (number == 21) {
            neChet(40, number);
            Answer(A2, A4, A1, A3, number);//окончен первый этап
        } else if (number == 22){//выход в меню
            text.setText(Constat.myStrok.get(number));
            invisibleA();
            exit.setVisibility(View.VISIBLE);
            s = n;
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double f =(11/(s+11))*100;//формула подсчета статистики
                    int st1 = (int) f;
                    s1 = st1;
                    if(st1>90){
                        ocenka1 = "% отлично";
                    }else if(st1>75){
                        ocenka1 = "% хорошо";
                    }else  if(st1>60){
                        ocenka1 = "% удолетворительно";
                    }else {
                        ocenka1 = "% неудолетворительно";
                    }//определение оценки
                    String str1 = s1.toString().concat(ocenka1);//объединение оценки и процента в одну строку
                    c = Calendar.getInstance();//опрделение даты прохождения
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy kk:mm - ");//формат даты
                    datetime = dateFormat.format(c.getTime());//занесение даты в строку
                    String str2 = datetime.concat(str1);//объединение даты и оценки в одну строку
                    dateList.add(str2);//добавление строки в список
                    save();//сохранение списка в телефоне
                    s = 0;
                    n = 0;
                    Intent i = new Intent(Start.this, second.class);
                    startActivity(i);
                    tema_2.setVisibility(View.VISIBLE);//появление следующей темы
                }
            });
        } else if(number == 23){
        }
    }
    public void save(){
        sPref = getSharedPreferences("Save1",MODE_PRIVATE);//создание папки с сохраненными значениями в телефоне
        SharedPreferences.Editor ed = sPref.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(dateList);//сохранение списка
        ed.putStringSet(SAVE_MASSIV, set);//добавления списка в папку
        ed.apply();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        save();
    }
}


