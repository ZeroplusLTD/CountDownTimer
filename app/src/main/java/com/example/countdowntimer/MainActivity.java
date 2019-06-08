package com.example.countdowntimer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView countImage;
    private TextView hideText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countImage = findViewById(R.id.imageCount);
        hideText = findViewById(R.id.hideText);

        new CountDownTimer(9*1000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {

                hideText.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {

                Intent intent = new Intent(MainActivity.this, SecoundActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();


        hideText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String COUNT = hideText.getText().toString();
                if (COUNT.equals("8")){
                    countImage.setImageResource(R.drawable.c1);
                }else if (COUNT.equals("7")){
                    countImage.setImageResource(R.drawable.c2);
                }else if (COUNT.equals("6")){
                    countImage.setImageResource(R.drawable.c3);
                }else if (COUNT.equals("5")){
                    countImage.setImageResource(R.drawable.c4);
                }else if (COUNT.equals("4")){
                    countImage.setImageResource(R.drawable.c5);
                }else if (COUNT.equals("3")){
                    countImage.setImageResource(R.drawable.c6);
                }else if (COUNT.equals("2")){
                    countImage.setImageResource(R.drawable.c7);
                }else if (COUNT.equals("1")){
                    countImage.setImageResource(R.drawable.c8);
                }else if (COUNT.equals("0")){
                    countImage.setImageResource(R.drawable.finish);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
}
