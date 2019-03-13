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

import static com.marvinabum.bullsandcows.BullsandcowsJava.bulls;
import static com.marvinabum.bullsandcows.BullsandcowsJava.cows;
import static com.marvinabum.bullsandcows.BullsandcowsJava.number;
import static com.marvinabum.bullsandcows.BullsandcowsJava.rand;

public class JavaGuess extends AppCompatActivity {

    private Button submitJavaGuess;
    private Button javaGuessContinue;
    private ImageButton javaToMainMenu;
    private EditText aiGuessET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_java_guess);
        aiGuessET = (EditText) findViewById(R.id.blockchainSecretText);
        javaToMainMenu = (ImageButton) findViewById(R.id.javaToMainMenu);

        submitJavaGuess = (Button) findViewById(R.id.submitJavaGuess);
        submitJavaGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BullsandcowsJava banc = new BullsandcowsJava();
                BullsandcowsJava.number = rand.nextInt(10000);
                System.out.println(number);
                BullsandcowsJava.guess = Integer.valueOf(aiGuessET.getText().toString());
                javaGuessContinue.setEnabled(true);
            }
        });

        javaGuessContinue = (Button) findViewById(R.id.javaGuessContinue);
        javaGuessContinue.setEnabled(false);
        javaGuessContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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