package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.teste04.R;

public class SplashActivity extends AppCompatActivity {

    public static final int Time_OUT_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cumutarTelaSplash();
    }

    private void cumutarTelaSplash(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent TelaPrincipal = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(TelaPrincipal);
                finish();
            }
        },Time_OUT_SPLASH);
    }

}