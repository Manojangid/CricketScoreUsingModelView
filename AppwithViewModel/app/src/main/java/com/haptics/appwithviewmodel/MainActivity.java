package com.haptics.appwithviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView runs, overTextView;
    ImageView btn_inc, btn_dec, btn_inc2, btn_dec2;
    ScoreViewModel scoreViewModel;
    Button reset,four,six;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        four = findViewById(R.id.four);
        six = findViewById(R.id.six);
        runs = findViewById(R.id.runs);
        reset = findViewById(R.id.reset);
        overTextView = findViewById(R.id.over);
        btn_dec = findViewById(R.id.btn_dec);
        btn_inc = findViewById(R.id.btn_inc);
        btn_dec2 = findViewById(R.id.btn_dec2);
        btn_inc2 = findViewById(R.id.btn_inc2);

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        runs.setText((String.valueOf(scoreViewModel.getRuns())));
        overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());


        //Listeners for runs
        btn_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Increment runs
                int run = scoreViewModel.getRuns();
                ++run;
                scoreViewModel.setRuns(run);
                runs.setText(String.valueOf(run));
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Decrement runs
                int run = scoreViewModel.getRuns();
                if (run > 0) {
                    --run;
                    scoreViewModel.setRuns(run);
                    runs.setText(String.valueOf(run));
                }

            }
        });
        //Listeners for overs
        btn_inc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Increment over
                int first = scoreViewModel.getFirstDigit();
                int second = scoreViewModel.getSecondDigit();
                if (second == 6) {
                    scoreViewModel.setSecondDigit(0);
                    ++first;
                    scoreViewModel.setFirstDigit(first);
                    overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());
                }else{
                    ++second;
                    scoreViewModel.setSecondDigit(second);
                    overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());
                }

            }
        });

        btn_dec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Decrement over
                int first = scoreViewModel.getFirstDigit();
                int second = scoreViewModel.getSecondDigit();
                if(first==1&&second==0){
                    Toast.makeText(MainActivity.this, "0.0", Toast.LENGTH_SHORT).show();
                }else{
                    if(second==0)
                    {
                        --first;
                        scoreViewModel.setSecondDigit(6);
                        scoreViewModel.setFirstDigit(first);
                        overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());
                    }else
                    {
                        --second;
                        scoreViewModel.setSecondDigit(second);
                        overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());
                    }

                }

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int run = scoreViewModel.getRuns();
                run = run+4;
                scoreViewModel.setRuns(run);
                runs.setText(String.valueOf(run));
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int run = scoreViewModel.getRuns();
                run = run+6;
                scoreViewModel.setRuns(run);
                runs.setText(String.valueOf(run));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreViewModel.setRuns(0);
                runs.setText(String.valueOf(scoreViewModel.getRuns()));
                scoreViewModel.setFirstDigit(1);
                scoreViewModel.setSecondDigit(0);
                overTextView.setText(scoreViewModel.getFirstDigit() + "." + scoreViewModel.getSecondDigit());
            }
        });

    }
}
