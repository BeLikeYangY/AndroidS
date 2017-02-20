package com.example.android.inclassassignment04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("Username");
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(username);

        String gender = intent.getStringExtra("Gender");
        String emotion = intent.getStringExtra("Emotion");
        ImageView img = (ImageView)findViewById(R.id.picture);

        if (gender.equals("female")){
            switch (emotion){
                case "happy":
                    img.setImageResource(R.drawable.femalehappy);
                    break;
                case "sad":
                    img.setImageResource(R.drawable.femalesad);
                    break;
                case "angry":
                    img.setImageResource(R.drawable.femaleangry);
                    break;
            }
        } else if (gender.equals("male")){
            switch (emotion){
                case "happy":
                    img.setImageResource(R.drawable.malehappy);
                    break;
                case "sad":
                    img.setImageResource(R.drawable.malesad);
                    break;
                case "angry":
                    img.setImageResource(R.drawable.maleangry);
                    break;
            }
        }

        TextView message = (TextView)findViewById(R.id.displayMessage);

        switch (emotion){
            case "happy":
                message.setText("Wow\nYou look so happy!");
                message.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
            case "sad":
                message.setText("Awww, don't cry... \nCheer up!");
                message.setGravity(Gravity.CENTER_HORIZONTAL);
                break;      
            case "angry":
                message.setText("I'm sorry!");
                message.setGravity(Gravity.CENTER_HORIZONTAL);
                break;
        }
    }


}
