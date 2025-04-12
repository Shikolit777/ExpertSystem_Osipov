package com.example.expertsystem_osipov;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AlertDialog(String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {dialog.cancel();}
                });

        AlertDialog alter = builder.create();
        alter.show();
    }

    public void Perexod1(View view)
    {
        setContentView(R.layout.step_1);
    }

    public TextView Name;
    public TextView Familiya;

    public void Perexod2(View view)
    {
        Name = findViewById(R.id.Ves);
        Familiya = findViewById(R.id.Rost);
        EditText tbName = findViewById(R.id.Ves);
        String User_Name = tbName.getText().toString();
        EditText tbFamiliya = findViewById(R.id.Rost);
        String User_Familya = tbFamiliya.getText().toString();

        if(Name.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите ваше имя.");
        else if(Familiya.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите вашу фамилию.");
        else {
            setContentView(R.layout.step_2);
        }

        TextView tbTextVozrast = findViewById(R.id.nadpis);
        tbTextVozrast.setText("Отлично, " + User_Name + " " + User_Familya + "\nКак часто вы готовы заниматься спортом?");
    }

    public RadioButton variant1;
    public RadioButton variant2;
    public RadioButton variant3;
    public RadioButton variant4;
    public void Perexod3(View view)
    {
        variant1 = findViewById(R.id.variant1);
        variant2 = findViewById(R.id.variant2);
        variant3 = findViewById(R.id.variant3);
        variant4 = findViewById(R.id.variant4);

        if (variant1.isChecked() || variant2.isChecked() || variant3.isChecked() || variant4.isChecked())
        {
            setContentView(R.layout.step_3);
        }
        else
        {
            AlertDialog("Уведомление", "Пожалуйста, выберите один из предложенных вариантов.");
        }
    }

    public CheckBox CheckBox1;
    public CheckBox CheckBox2;
    public CheckBox CheckBox3;
    public CheckBox CheckBox4;

    public void Perexod4(View view)
    {
        CheckBox1 = findViewById(R.id.checkBox1);
        CheckBox2 = findViewById(R.id.checkBox2);
        CheckBox3 = findViewById(R.id.checkBox3);
        CheckBox4 = findViewById(R.id.checkBox4);

        if (CheckBox1.isChecked() || CheckBox2.isChecked() || CheckBox3.isChecked() || CheckBox4.isChecked())
        {
            setContentView(R.layout.step_4);
        }
        else
        {
            AlertDialog("Уведомление", "Пожалуйста, выберите один или несколько из предложенных вариантов.");
        }
    }

    public EditText Ves;
    public EditText Rost;
    public void Perexod5(View view)
    {
        Ves = findViewById(R.id.Ves);
        Rost = findViewById(R.id.Rost);

        if(Ves.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите ваш вес.");
        else if(Rost.getText().length() == 0) AlertDialog("Уведомление", "Пожалуйста, укажите ваш рост.");
        else
        {
            setContentView(R.layout.step_5);
        }
    }

    public RadioButton Myzskoi;
    public RadioButton Zhenskiy;
    public void Perexod6(View view)
    {
        Myzskoi = findViewById(R.id.Myzskoi);
        Zhenskiy = findViewById(R.id.Zhenskiy);
        if (Myzskoi.isChecked() || Zhenskiy.isChecked())
        {
            setContentView(R.layout.main);
        }
        else
        {
            AlertDialog("Уведомление", "Пожалуйста, укажите ваш пол.");
        }
    }
}
