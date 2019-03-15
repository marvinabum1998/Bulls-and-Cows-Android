package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import org.web3j.protocol.core.RemoteCall;
import java.math.BigInteger;

public class BlockchainResults extends AppCompatActivity {

    private Button quitToMainMenuBC;
    private Button newGuessBlockchain;
    private Button showBlockchainResult;
    private TextView blockchainResultText;
    private Bullsandcows contract;
    private BigInteger bulls;
    private BigInteger cows;
    private static int count=1;

    private class ContractAsyncTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
            ContractWrapper wrapper = new ContractWrapper();
            Bullsandcows contract = null;

            try {
                contract = wrapper.getContract();
                RemoteCall<BigInteger> rcCows = contract.getCows();
                try {
                cows = rcCows.send();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("You have " + cows + " cows");

                RemoteCall<BigInteger> rcBulls = contract.getBulls();
                try {
                    bulls = rcBulls.send();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("You have " + bulls + " bulls");

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
            super.onPostExecute(result);
            if(Integer.valueOf(bulls.toString()) == 4) {
                blockchainResultText.setText("Congratulations, you have guessed the right number!" );
                newGuessBlockchain.setEnabled(false);
            }
            else {
                blockchainResultText.setText("You have: (" + bulls + ") Bulls and (" + cows + ") Cows after (" + count + ") attempts. Please try again!" );
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_blockchain_results);

        blockchainResultText = (TextView) findViewById(R.id.javaResultText);

        new ContractAsyncTask().execute();

        quitToMainMenuBC = (Button) findViewById(R.id.quitToMainMenuBC);
        //blockchainResultText = (TextView) findViewById(R.id.blockchainResultText) ;
        quitToMainMenuBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 1;
                openMainMenu();
            }
        });

        newGuessBlockchain = (Button) findViewById(R.id.newGuessBlockchain);
        //blockchainResultText = (TextView) findViewById(R.id.blockchainResultText) ;
        newGuessBlockchain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                openPlayer2Screen();
            }
        });

    }

    public void openMainMenu() {
        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);

    }

    public void openPlayer2Screen() {
        Intent openPlayer2Screen = new Intent(this, Player2Blockchain.class);
        startActivity(openPlayer2Screen);

    }
}