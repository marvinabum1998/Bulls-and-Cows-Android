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
    }

        public void openRulesScreen() {
            Intent intent = new Intent(this, RulesScreen.class);
            startActivity(intent);
        }

        public static void main() {

            org.web3j.crypto.Credentials credentials = "0x6cdc4ad5F20Ade8c7D2586f71Bd06a29B32867B7";
        Bullsandcows bc = new Bullsandcows(0x6cdc4ad5F20Ade8c7D2586f71Bd06a29B32867B7, )
        }
}