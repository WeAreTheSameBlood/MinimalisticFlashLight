package com.hlybchenko.minimalisticflashlight;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonFlash;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        buttonFlash = findViewById(R.id.mainButtonFlash);
        flashClass = new FlashClass(this);
    }

    public void onClickFlash(View view){
    if (flashClass.isFlash_status()){
        flashClass.flashOff();
        buttonFlash.setText(R.string.main_flash_ON);
        buttonFlash.setBackgroundResource(R.drawable.circle_green);
    } else {
        flashClass.flashOn();
        buttonFlash.setText(R.string.main_flash_OFF);
        buttonFlash.setBackgroundResource(R.drawable.circle_red);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flashClass.isFlash_status()) {
            flashClass.flashOff();
        }
    }
}