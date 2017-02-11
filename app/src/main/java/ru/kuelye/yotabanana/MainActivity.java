package ru.kuelye.yotabanana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;

public class MainActivity extends AppCompatActivity {

    int minutes;
    boolean smsEnabled;
    int roubles;
    TextView roublesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Баланс 350 \u20BD");

        roublesTextView = (TextView) findViewById(R.id.priceTextView);
        final TextView minutesTextView = (TextView) findViewById(R.id.minutesTextView);
        SeekBar minutesSeekBar = (SeekBar) findViewById(R.id.seekBar);
        minutesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
    Switch smsSwitch = (Switch) findViewById(R.id.switch1);
    smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean enabled) {
            smsEnabled = enabled;
            updateRoubles();
    minutes = 600;
    smsEnabled = false;
    minutesSeekBar.setProgress(2);
    smsSwitch.setChecked(false);
    updateRoubles();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.char_item:

                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);

                return true;
            default:
                return true;
        }
    }

    /

    private void updateRoubles() {
        roubles = minutes / 2;
        if (smsEnabled == true) {
            roubles += 50;
        }
        roublesTextView.setText(String.valueOf(roubles));
    }

}
