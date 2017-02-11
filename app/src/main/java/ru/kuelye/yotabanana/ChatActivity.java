package ru.kuelye.yotabanana;

/**
 * Created by User on 2/11/2017.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

        ListView listView = (ListView) findViewById(R.id.listView);
        Context context = this;
        int resource = android.R.layout.simple_list_item_1;
        List<String> messages = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (context, resource, messages);
        listView.setAdapter(adapter);

        final EditText editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String message = editText.getText().toString();
                    addMessage(message);
                }
                return true;
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Чат");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close_black_36dp);
    }

    private void addMessage(String message) {
        adapter.add(message);
        if (message.equals("Привет!")) {
            
        }
    }

}
