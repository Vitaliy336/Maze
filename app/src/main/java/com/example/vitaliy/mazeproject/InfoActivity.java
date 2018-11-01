package com.example.vitaliy.mazeproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Button share = findViewById(R.id.share);
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String textToSend="some text";
        intent.putExtra(Intent.EXTRA_TEXT, textToSend);
        try
        {
            startActivity(Intent.createChooser(intent, "Case discribe"));
        }
        catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(getApplicationContext(), "Some error", Toast.LENGTH_SHORT).show();
        }
    }
}
