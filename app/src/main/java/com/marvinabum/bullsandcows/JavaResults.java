package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import static com.marvinabum.bullsandcows.BullsandcowsJava.bulls;
import static com.marvinabum.bullsandcows.BullsandcowsJava.cows;

public class JavaResults extends AppCompatActivity {

    private Button quitToMainMenuJava;
    private Button newGuessJava;
    private TextView javaResultText;
    private int count;

    private class ContractAsyncTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
            BullsandcowsJava banc = new BullsandcowsJava();
            banc.calculate();
            System.out.println("You have " + bulls + " bulls");
            System.out.println("You have " + cows + " cows");
            return "Success";
        }

        protected void onProgressUpdate(Integer... progress) {
            //setProgressPercent(progress[0]);
        }

        protected void onPostExecute(String result) {
            //showDialog("Downloaded " + result + " bytes");
            super.onPostExecute(result);
            javaResultText.setText("You have: (" + bulls + ") Bulls and (" + cows + ") Cows after " + count + " attempts. Please try again!" );
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_results);

        quitToMainMenuJava = (Button) findViewById(R.id.quitToMainMenuJava);
        javaResultText = (TextView) findViewById(R.id.javaResultText);
        count++;
        new ContractAsyncTask().execute();


        quitToMainMenuJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });

        newGuessJava = (Button) findViewById(R.id.newGuessJava);
        newGuessJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openJavaGuess();
            }
        });
    }

    public void openMainMenu() {
        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);
    }

    public void openJavaGuess() {
        Intent openJavaGuess = new Intent(this, JavaGuess.class);
        startActivity(openJavaGuess);
    }
}
