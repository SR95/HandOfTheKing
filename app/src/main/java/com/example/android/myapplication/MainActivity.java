package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    private String[] houses = new String[20];
    ListView listView;
    ArrayAdapter<String> houseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateDatabase();

        listView = (ListView) findViewById(R.id.houseListView);
        houseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        houseAdapter.add(houses[0].substring(0, 1).toUpperCase() + houses[0].substring(1));
        houseAdapter.add(houses[1].substring(0, 1).toUpperCase() + houses[1].substring(1));
        houseAdapter.add(houses[2].substring(0, 1).toUpperCase() + houses[2].substring(1));
        houseAdapter.add(houses[3].substring(0, 1).toUpperCase() + houses[3].substring(1));
        houseAdapter.add(houses[4].substring(0, 1).toUpperCase() + houses[4].substring(1));

        listView.setAdapter(houseAdapter);
        listView.setOnItemClickListener(this);
    }

    public void updateDatabase() {
        houses[0] = "stark";
        houses[1] = "baratheon";
        houses[2] = "tyrell";
        houses[3] = "targaryen";
        houses[4] = "lannister";
    }

    /* Function Declarations */
    public Boolean checkArray(String message) {
        return Arrays.asList(houses).contains(message.toLowerCase());
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String messageIntermediate = editText.getText().toString();

        TextView errorText = findViewById(R.id.errorTextView);
        messageIntermediate = messageIntermediate.toLowerCase();
        String message = messageIntermediate.substring(0, 1).toUpperCase() + messageIntermediate.substring(1);

        if (checkArray(message.toLowerCase())) {
            errorText.setText("");
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else if (message.equals("")) {
            String errorMessage = "You need to enter one of the great houses. Try Again.";
            errorText.setText(errorMessage);
        } else {
            String errorMessage = "Your Entry is not one of the great houses. Try Again.";
            errorText.setText(errorMessage);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String houseName = houseAdapter.getItem(i);
        houseName = houseName.substring(0, 1).toUpperCase() + houseName.substring(1);
        //Toast.makeText(this, "You clicked on House "+houseName, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, houseName);
        startActivity(intent);
    }
}
