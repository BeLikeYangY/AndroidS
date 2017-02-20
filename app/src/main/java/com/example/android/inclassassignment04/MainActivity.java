package com.example.android.inclassassignment04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    String gender;
    String emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String getText(){
        EditText editText = (EditText) findViewById(R.id.editText);
        String username = editText.getText().toString();
        return username;
    }

    public void onRadioButtonGenderClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.female:
                if (checked) {
                    gender = "female";
                }
                break;
            case R.id.male:
                if (checked) {
                    gender = "male";
                }
                break;
        }

    }

    public void onRadioButtonEmotionClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.happy:
                if (checked) {
                    emotion = "happy";
                }
                break;
            case R.id.sad:
                if (checked) {
                    emotion = "sad";
                }
                break;
            case R.id.angry:
                if (checked) {
                    emotion = "angry";
                }
        }
    }

    public boolean isChecked(){
        boolean checked =((CheckBox)findViewById(R.id.checkbox)).isChecked();
        return checked;
    }

    public void launch(View view){
        if (isChecked()){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Come check out this awesome app that can create avatars for you!");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else{
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("Username", getText());
            intent.putExtra("Gender",gender);
            intent.putExtra("Emotion",emotion);
            startActivity(intent);
        }
    }
}
