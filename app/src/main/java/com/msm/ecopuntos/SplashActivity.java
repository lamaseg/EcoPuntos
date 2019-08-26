package com.msm.ecopuntos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        declararControles();
        configurarControles();
    }

    private void declararControles(){
        imgLogo = (ImageView) findViewById(R.id.imgLogo);
    }

    private void configurarControles()
    {
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(2000);
        animation.setStartOffset(1000);
        animation.setFillAfter(true);
        imgLogo.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Thread timer = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lanzarMenuPrincipal();
                            finish();
                        }
                    }
                };
                timer.start();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void lanzarMenuPrincipal() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}