package com.marvinabum.bullsandcows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    private Button rulesBtn;
    private Button newGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_menu);

        rulesBtn = (Button) findViewById(R.id.rulesBtn);
        newGameBtn = (Button) findViewById(R.id.blockchainBtn);

        rulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRulesScreen();
            }
        });


        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGame();
            }
        });
    }


    public void openRulesScreen() {
        Intent openRules = new Intent(this, Rules.class);
        startActivity(openRules);
    }

    public void openNewGame() {
        Intent openNewGame = new Intent(this, Player1BC.class);
        startActivity(openNewGame);
    }
}
