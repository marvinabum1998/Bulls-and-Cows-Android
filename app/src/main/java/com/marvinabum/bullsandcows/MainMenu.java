package com.marvinabum.bullsandcows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    private Button openRules;
    private Button openNewBlockchain;
    private Button openNewJava;
    private Button openInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_menu);



        openRules = (Button) findViewById(R.id.openRules);
        openNewBlockchain = (Button) findViewById(R.id.openNewBlockchain);
        //openNewJava = (Button) findViewById(R.id.openNewJava);
        openInformation = (Button) findViewById(R.id.openInformation);


        openRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRulesScreen();
            }
        });


        openNewBlockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewBlockchain();
            }
        });

        /*openNewJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewJava();
            }
        }); */
    }


    public void openRulesScreen() {
        Intent openRules = new Intent(this, Rules.class);
        startActivity(openRules);
    }

    public void openNewBlockchain() {
        Intent openNewBlockchain = new Intent(this, Player1Blockchain.class);
        startActivity(openNewBlockchain);
    }

    public void openNewJava() {
        Intent openNewJava = new Intent(this, JavaGuess.class);
        startActivity(openNewJava);
    }
}
