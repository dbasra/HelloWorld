package com.example.daven.helloworld;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * Created by Daven on 3/29/15.
 */
public class SoloScreen extends Activity {
    private NumberPicker min, ho, sec;
    private TextView symbolFinish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.solopage);
        min = (NumberPicker) findViewById(R.id.numberPicker2);
        ho = (NumberPicker) findViewById(R.id.numberPicker);
        sec = (NumberPicker) findViewById(R.id.numberPicker3);
        min.setMaxValue(59);
        min.setMinValue(0);
        ho.setMaxValue(12);
        ho.setMinValue(0);
        sec.setMaxValue(59);
        sec.setMinValue(0);
        symbolFinish = (TextView) findViewById(R.id.textView2);


    }

    public void startTimer(View view) {
        final int count;
        int second = sec.getValue()*1000;
        final int minute = (min.getValue()*60) * 1000;
        final int hour = (ho.getValue()*3600) * 1000;
        count = second + minute + hour;

        new CountDownTimer(count, 1000){
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            public void onTick(long millisUntilFinished){
                if(sec.getValue() == 0){
                    if (min.getValue() == 0){
                        ho.setValue((int) ((millisUntilFinished)/3600000));
                        min.setValue(59);
                        sec.setValue(59);
                    } else {
                        min.setValue((int) ((millisUntilFinished - hour) / 60000));
                        sec.setValue(59);
                    }
                }else {
                    sec.setValue((int) ((millisUntilFinished - minute - hour) / 1000));
                }
            }
            public void onFinish(){
                sec.setValue(0);
                symbolFinish.setText("DONE!");
            }
        }.start();
    }
}
