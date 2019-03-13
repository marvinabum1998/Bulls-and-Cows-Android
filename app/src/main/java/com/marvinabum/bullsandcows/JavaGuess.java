package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class JavaGuess extends AppCompatActivity {

    private Button javaGuessBtn;
    private ImageButton javaToMainMenu;
    private EditText aiGuessET;
    private int javaGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_java_guess);

        javaGuessBtn = (Button) findViewById(R.id.javaGuessBtn);

        aiGuessET = (EditText) findViewById(R.id.blockchainSecretText);

        javaToMainMenu = (ImageButton) findViewById(R.id.javaToMainMenu);

        javaGuessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BullsandcowsJava banc = new BullsandcowsJava();
                BullsandcowsJava.guess = Integer.valueOf(aiGuessET.getText().toString());

                openJavaResults();
            }
        });

        javaToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }

    public void openJavaResults() {
        Intent openJavaResults = new Intent(this, JavaResults.class);
        startActivity(openJavaResults);
    }

    public void openMainMenu() {
        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);
    }

}