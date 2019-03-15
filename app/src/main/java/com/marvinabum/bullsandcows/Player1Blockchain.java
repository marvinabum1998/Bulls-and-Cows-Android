package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import java.math.BigInteger;


public class Player1Blockchain extends AppCompatActivity {

    private Button submitBlockchainSecret;
    private Button blockchainSecretContinue;
    private ImageButton player1ToMainMenu;
    private EditText secretNumber1;
    private BigInteger secret;

    /*public Bullsandcows GetContract() throws Exception {
        if (this.contract== null) {
            ContractWrapper wrapper = new ContractWrapper();
            System.out.println("I am setting the contract " + contract);
            this.contract = wrapper.getContract();
        }
        return this.contract;
    }*/

    private class ContractAsyncTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            ContractWrapper wrapper = new ContractWrapper();
            Bullsandcows contract = null;

            try {
                contract = wrapper.getContract();
            } catch (Exception e) {
                e.printStackTrace();
            }

            RemoteCall<TransactionReceipt> receipt = contract.setPosition(new BigInteger(params[0]));
            System.out.println("The secret is " + params[0]);

            try {
                TransactionReceipt send = receipt.send();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Success";
        }

        protected void onProgressUpdate(Integer... progress) {
            //setProgressPercent(progress[0]);
        }

        protected void onPostExecute(String result) {
            //showDialog("Downloaded " + result + " bytes");
            //Toast.makeText(getApplicationContext(), "Completed"), Toast.LENGTH_LONG;
            super.onPostExecute(result);
            blockchainSecretContinue.setEnabled(true);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_player1_bc);



        player1ToMainMenu = (ImageButton) findViewById(R.id.player1ToMainMenu);
        player1ToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });


        submitBlockchainSecret = (Button) findViewById(R.id.submitBlockchainSecret);
        submitBlockchainSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secretNumber1 = (EditText) findViewById(R.id.blockchainSecretText);
                secret = new BigInteger(secretNumber1.getText().toString());
                new ContractAsyncTask().execute(secretNumber1.getText().toString());
            }
        });

        blockchainSecretContinue = (Button) findViewById(R.id.blockchainSecretContinue);
        blockchainSecretContinue.setEnabled(false);
        blockchainSecretContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayer2Blockchain();
            }
        });
    }

    public void openPlayer2Blockchain() {
        Intent intent4 = new Intent(this, Player2Blockchain.class);
        startActivity(intent4);
    }

    public void openMainMenu() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

}

