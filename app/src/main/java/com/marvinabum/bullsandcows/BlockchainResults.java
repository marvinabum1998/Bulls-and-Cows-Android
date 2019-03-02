package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class BlockchainResults extends AppCompatActivity {

    //private Button newGuessBlockchain;
    private Button quitToMainMenuBC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_blockchain_results);


       /* newGuessBlockchain = (Button) findViewById(R.id.newGuessBlockchain);
        newGuessBlockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer2Blockchain();
            }
        }); */

        quitToMainMenuBC = (Button) findViewById(R.id.quitToMainMenuBC);
        quitToMainMenuBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });

    }

   /* public void openPlayer2Blockchain() {

        Intent openPlayer2 = new Intent(this, Player2Blockchain.class);
        startActivity(openPlayer2);
    } */

    public void openMainMenu() {

        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);

    }
}