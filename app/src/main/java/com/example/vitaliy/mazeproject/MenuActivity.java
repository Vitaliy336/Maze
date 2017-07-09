package com.example.vitaliy.mazeproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        startService(new Intent(this, MyService.class));

        //   String fontPath = "fonts/Pixel.tff";

        Button start = (Button) findViewById(R.id.StartGame);
        start.setOnClickListener(this);
        TextView name = (TextView) findViewById(R.id.Name);
        Button info = (Button) findViewById(R.id.info);
        info.setOnClickListener(this);
        Button off = (Button)findViewById(R.id.off);
        off.setOnClickListener(this);
        Button on = (Button)findViewById(R.id.on);
        on.setOnClickListener(this);


        // Typeface typeface = Typeface.createFromAsset(getAssets(), fontPath);
        //  name.setTypeface(typeface);

        Animation scale = AnimationUtils.loadAnimation(this, R.anim.myscale);
        scale.setFillAfter(true);
        scale.setStartOffset(0);
        name.setAnimation(scale);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.StartGame:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.info:
                Intent intent1 = new Intent(this, InfoActivity.class);
                startActivity(intent1);
                break;
            case R.id.on:
                startService(new Intent(MenuActivity.this, MyService.class));
            case R.id.off:
                stopService(new Intent(MenuActivity.this, MyService.class));
        }
    }
}
