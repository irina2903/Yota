package ru.kuelye.yotabanana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int minutes;
    boolean smsEnabled;
    int roubles;
    TextView roublesTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar minutesSeekBar = (SeekBar) findViewById(R.id.seekBar);
        final Switch smsSwitch = (Switch) findViewById(R.id.switch1);
        roublesTextView = (TextView) findViewById(R.id.priceTextView);
        minutesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                minutes = i * 200 + 200;
                updateRoubles();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                smsEnabled = b;
                updateRoubles();

            }
        });


    }
    private void updateRoubles() {
        roubles = minutes / 2;
        if (smsEnabled == true) {
            roubles += 50;
        }
        roublesTextView.setText(String.valueOf(roubles));
    }

}
