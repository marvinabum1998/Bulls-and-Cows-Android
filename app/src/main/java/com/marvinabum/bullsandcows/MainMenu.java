package com.marvinabum.bullsandcows;

import android.net.Credentials;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.view.View;
import org.web3j.protocol.Web3j;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
        getSupportActionBar().hide();

        rulesBtn = (Button) findViewById(R.id.rulesBtn);
        rulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRulesScreen();
            }
        });

        newGameBtn = (Button) findViewById(R.id.newgamebtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewGame();
            }
        });
    }


    public void openRulesScreen() {
        Intent intent2 = new Intent(this, RulesScreen.class);
        startActivity(intent2);
    }

    public void openNewGame() {
        Intent intent3 = new Intent(this, Player1Screen.class);
        startActivity(intent3);
    }
}
