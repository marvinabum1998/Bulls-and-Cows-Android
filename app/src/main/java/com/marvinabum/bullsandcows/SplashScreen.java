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

        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        LogoLauncher LogoLauncher = new LogoLauncher();
        LogoLauncher.start();
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
}
}
