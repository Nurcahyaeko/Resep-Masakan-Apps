package com.apps.aplikasiresepmasakan.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.apps.aplikasiresepmasakan.R;

public class SplashScreenActivity extends AppCompatActivity {

    private ImageView gambarSplash;

    private final int delaay_Splash = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setBackgroundDrawable(null);

        inisialisasiTampilan();
        animasiLogo();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                finish();
            }
        }, 4*1000);


    }

    private void inisialisasiTampilan(){
        gambarSplash = findViewById(R.id.splash_img);
    }

    private void animasiLogo(){
        Animation animasiMuncul = AnimationUtils.loadAnimation(this, R.anim.splash_animation);

        animasiMuncul.setDuration(delaay_Splash);

        gambarSplash.startAnimation(animasiMuncul);


    }
}
