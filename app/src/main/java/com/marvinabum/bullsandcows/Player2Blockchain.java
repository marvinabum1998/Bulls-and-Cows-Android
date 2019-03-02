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

    private Button submitGuessBtn;
    private EditText guessNumber1;
    //public Bullsandcows contract;
    private BigInteger guess;

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

            RemoteCall<TransactionReceipt> receipt = contract.checkGuess(new BigInteger(params[0]));
            System.out.println("The guess is " + params[0]);

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
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_player2_bc);


        submitGuessBtn = (Button) findViewById(R.id.submitGuessBtn);
        submitGuessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessNumber1 = (EditText) findViewById(R.id.blockchainSecretText);
                guess = new BigInteger(guessNumber1.getText().toString());
                new ContractAsyncTask().execute(guessNumber1.getText().toString());
                openResults();
            }
        });
    }

    public void openResults() {

        Intent openResults = new Intent(this, BlockchainResults.class);
        startActivity(openResults);
    }
}
