package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JavaResults extends AppCompatActivity {

    private Button quitToMainMenuJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_results);

        quitToMainMenuJava = (Button) findViewById(R.id.quitToMainMenuJava);

        quitToMainMenuJava.setOnClickListener(new View.OnClickListener() {
            //@SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                /* BullsandcowsJava banc = new BullsandcowsJava();
                BullsandcowsJava.guess = Integer.valueOf(aiGuessET.getText().toString());
                Toast.makeText(getApplicationContext(), "The guess you entered is " + BullsandcowsJava.guess, Toast.LENGTH_LONG); */
                openMainMenu();
            }
        });
    }

    public void openMainMenu() {
        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);
    }
}
