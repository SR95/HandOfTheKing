package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    String TAG = "DisplayMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.houseName);
        textView.setText("House "+message);
        Log.i(TAG, "House "+message);

        TextView tV_houseText = findViewById(R.id.houseText);
        TextView tV_extraText = findViewById(R.id.additionalDetails);
        ImageView iV_sigil = findViewById(R.id.houseSigil);

        if(message.toLowerCase().equals("stark"))
        {
            tV_houseText.setText(R.string.StarkTextIntro);
            tV_extraText.setText(R.string.StarkExtras);
            iV_sigil.setImageResource(R.drawable.house_stark_shield);
        }
        else if(message.toLowerCase().equals("baratheon"))
        {
            tV_houseText.setText(R.string.BaratheonTextIntro);
            tV_extraText.setText(R.string.BaratheonExtras);
            iV_sigil.setImageResource(R.drawable.house_baratheon_shield);
        }
        else if(message.toLowerCase().equals("tyrell"))
        {
            tV_houseText.setText(R.string.TyrellTextIntro);
            tV_extraText.setText(R.string.TyrellExtras);
            iV_sigil.setImageResource(R.drawable.house_tyrell_shield);
        }
        else if(message.toLowerCase().equals("targaryen"))
        {
            tV_houseText.setText(R.string.TargaryenTextIntro);
            tV_extraText.setText(R.string.TargaryenExtras);
            iV_sigil.setImageResource(R.drawable.house_targaryen_shield);
        }
        else if(message.toLowerCase().equals("lannister"))
        {
            tV_houseText.setText(R.string.LannisterTextIntro);
            tV_extraText.setText(R.string.LannisterExtras);
            iV_sigil.setImageResource(R.drawable.house_lannister_shield);
        }
    }
}
