package com.bynex.android.app.addinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView result, randomNo;
    Switch showHideRes;
    ImageButton playPause;
    boolean isStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.curr_no);
        randomNo = findViewById(R.id.random_no);
        showHideRes = findViewById(R.id.switch1);
        playPause = findViewById(R.id.imageButton);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStart) {
                    isStart = false;
                } else {
                    isStart = true;
                    start();
                }
            }
        });

        showHideRes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    result.setVisibility(View.INVISIBLE);
                } else {
                    result.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void start() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                while (isStart) {

                    Random random = new Random();
                    int n = random.nextInt(9);
                    n += 1;
                    randomNo.setText(n + "");

                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {

                    }

                    int x = Integer.parseInt(result.getText().toString());
                    x += n;
                    result.setText(x + "");
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}