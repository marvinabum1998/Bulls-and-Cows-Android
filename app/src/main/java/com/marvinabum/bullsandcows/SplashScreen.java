package com.marvinabum.bullsandcows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
// This code is used to make the app fullscreen
        setContentView(R.layout.activity_splash_screen);

        LogoLauncher LogoLauncher = new LogoLauncher();
        LogoLauncher.start();
// Creates an instance of LogoLauncher and starts it
    }


private class LogoLauncher extends Thread{
        public void run() {
            try{
                sleep(3500);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashScreen.this, MainMenu.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }
// This class displays the splash screen for 3.5 seconds before automatically transitioning to the main menu
}
}
