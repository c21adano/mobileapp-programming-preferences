package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button button;

    EditText name;
    SharedPreferences sp;
    String TextThing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.TexteditThing);
        button = (Button) findViewById(R.id.buttonTwo);

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextThing = name.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                editor.putString("text", TextThing);
                editor.commit();

                openActivity1();

            }
        });

    }
    public void openActivity1(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}