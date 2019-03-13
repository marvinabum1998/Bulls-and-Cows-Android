package com.marvinabum.bullsandcows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JavaResults extends AppCompatActivity {

    private Button quitToMainMenuJava;
    private TextView javaResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_results);

        quitToMainMenuJava = (Button) findViewById(R.id.quitToMainMenuJava);
        javaResultText = (TextView) findViewById(R.id.blockchainResultText);

        quitToMainMenuJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainMenu();
            }
        });
    }

    public void openMainMenu() {
        Intent openMainMenu = new Intent(this, MainMenu.class);
        startActivity(openMainMenu);
    }
}
