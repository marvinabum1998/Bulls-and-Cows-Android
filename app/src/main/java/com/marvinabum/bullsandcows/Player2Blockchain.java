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
import android.widget.Toast;

import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import java.math.BigInteger;


public class Player2Blockchain extends AppCompatActivity {

    private Button submitBlockchainGuess;
    private Button continueToBlockchainResults;
    private EditText guessNumber1;
    //public Bullsandcows contract;
    private BigInteger guess;

    private class ContractAsyncTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
            ContractWrapper wrapper = new ContractWrapper();
            Bullsandcows contract = null;

            try {
                contract = wrapper.getContract();
            } catch (Exception e) {
                e.printStackTrace();
            }
            RemoteCall<TransactionReceipt> receipt = contract.checkGuess(new BigInteger(params[0]));
            try {
                TransactionReceipt send = receipt.send();
                System.out.println("The guess is " + params[0]);

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
            continueToBlockchainResults.setEnabled(true);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_player2_bc);


        submitBlockchainGuess = (Button) findViewById(R.id.submitBlockchainGuess);
        submitBlockchainGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessNumber1 = (EditText) findViewById(R.id.blockchainSecretText);
                guess = new BigInteger(guessNumber1.getText().toString());
                new ContractAsyncTask().execute(guessNumber1.getText().toString());
            }
        });

        continueToBlockchainResults = (Button) findViewById(R.id.continueToBlockchainResults);
        continueToBlockchainResults.setEnabled(false);
        continueToBlockchainResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResults();
            }
        });
    }

    public void openResults() {

        Intent openResults = new Intent(this, BlockchainResults.class);
        startActivity(openResults);
    }
}
