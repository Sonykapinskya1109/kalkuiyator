package com.example.kalkulyator;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
       EditText widthE = findViewById(R.id.textView11);
        EditText heightE = findViewById(R.id.textView12);
        EditText consupE = findViewById(R.id.textView13);
        EditText layersE = findViewById(R.id.textView14);
        EditText volumeE = findViewById(R.id.textView15);
        RadioButton radioButton1 = findViewById(R.id.radioButton);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);

        double width = Double.parseDouble(widthE.getText().toString());
        double height = Double.parseDouble(heightE.getText().toString());
        int layers = Integer.parseInt(layersE.getText().toString());
        double consup = Double.parseDouble(consupE.getText().toString());
        double volume = Double.parseDouble(volumeE.getText().toString());

        double surface = width * height;

        double totalPaint = surface * layers / consup;

        double paintReverse = 1.0;
        double canVolume = 0;

        if (radioButton3.isChecked()) {
            paintReverse = 1.0;
        } else if (radioButton2.isChecked()){
            paintReverse = 1.1;
        } else {
            paintReverse = 1.15;
        }

        canVolume = Math.ceil(totalPaint * paintReverse / volume);
        double paintCost = canVolume * volume * 100;

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Результат:");
        dialog.setMessage("Для покраски комнаты площадью " + surface + " кв. м. необходимо " + canVolume + " банок краски. Стоимость краски составит " + paintCost + " рублей.");
        dialog.show();

    }
}