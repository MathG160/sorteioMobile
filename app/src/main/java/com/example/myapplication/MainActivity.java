package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sorteio (View v) {
           Random random = new Random();
           TextView resultView = findViewById(R.id.txtResult);
           TextView minView  = (TextView) findViewById(R.id.txtNum1);
           TextView maxView = (TextView) findViewById(R.id.txtNum2);

           try {
               int min = Integer.parseInt(minView.getText().toString());
               int max = Integer.parseInt(maxView.getText().toString());

               if ((min) > max) {
                   error1();
               } else {
                   int sorted = random.nextInt((max-min)+1)+min;
                   resultView.setText(String.valueOf(sorted));
               }

           } catch (NumberFormatException e) {
               error2();

           }

    }

    private void error1() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Atenção!");
        alertDialog.setMessage("O valor máximo deve ser maior ou igual ao valor mínimo.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void error2() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Atenção!");
        alertDialog.setMessage("Os valores mínimo e/ou máximo não podem ficar vazios!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


}