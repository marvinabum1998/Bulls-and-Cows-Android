package com.marvinabum.bullsandcows;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
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

        if(!isConnected())
        {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Internet Connection Error!")
                    .setMessage("Please check your internet connection and try again!")
                    .setPositiveButton("Close Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }

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

        openInformation = (Button) findViewById(R.id.openInformation);
        openInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInformationPage();
            }
        });
    }

    private boolean isConnected()
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void openRulesScreen() {
        Intent openRules = new Intent(Intent.ACTION_VIEW, Uri.parse("https://marvinabum.com/game-rules"));
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

    public void openInformationPage() {
        Intent browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://marvinabum.com/blockchain-technology"));
        startActivity(browserintent);
    }
}
