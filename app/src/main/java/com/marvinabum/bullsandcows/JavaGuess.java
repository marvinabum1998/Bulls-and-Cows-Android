package com.marvinabum.bullsandcows;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JavaGuess extends AppCompatActivity {

    private Button javaGuessBtn;
    private EditText aiGuessET;
    private int javaGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_player1_bc);

        javaGuessBtn = (Button) findViewById(R.id.javaGuessBtn);

        aiGuessET = (EditText) findViewById(R.id.blockchainSecretText);

        javaGuessBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                BullsandcowsJava banc = new BullsandcowsJava();
                BullsandcowsJava.guess = Integer.valueOf(aiGuessET.getText().toString());
                Toast.makeText(getApplicationContext(), "The guess you entered is " + BullsandcowsJava.guess, Toast.LENGTH_LONG);
                openJavaResults();
            }
        });
    }

    public void openJavaResults() {
        Intent openJavaResults = new Intent(this, JavaResults.class);
        startActivity(openJavaResults);
    }

}