package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

public class Player2BC extends AppCompatActivity {

    private Button secretBtn;
    private EditText secretNumber;
    public Bullsandcows contract;

    public void SetContract(Bullsandcows contract){
        this.contract = contract;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_player1_screen);

        secretNumber = (EditText) findViewById(R.id.secretNumber);

        secretBtn = (Button) findViewById(R.id.secretBtn);

        secretBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //secret = Integer.valueOf(secretNumber.getText().toString());

                BigInteger secret = new BigInteger(secretNumber.getText().toString());
                RemoteCall<TransactionReceipt> receipt = contract.setPosition(secret);
                try {
                    TransactionReceipt future = receipt.send();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                openResults();
            }
        });
    }

    public void openResults() {
        Intent openResults = new Intent(this, Results.class);
        startActivity(openResults);
    }

}
