package com.eirandanan.simon;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View topRight, topLeft, bottomRight, bottomLeft;
    SoundPool soundPool;
    int sound1, sound2, sound3, sound4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupReferences();
        setupSoundPool();
    }

    private void setupSoundPool() {
        soundPool = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .build())
                .build();
        sound1 = soundPool.load(this, R.raw.sound1, 1);
        sound2 = soundPool.load(this, R.raw.sound2, 1);
        sound3 = soundPool.load(this, R.raw.sound3, 1);
        sound4 = soundPool.load(this, R.raw.sound4, 1);
    }

    private void setupReferences() {
        topRight = findViewById(R.id.topRight);
        topLeft = findViewById(R.id.topLeft);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);

        topRight.setOnTouchListener(onTouch);
        topLeft.setOnTouchListener(onTouch);
        bottomLeft.setOnTouchListener(onTouch);
        bottomRight.setOnTouchListener(onTouch);
    }

    View.OnTouchListener onTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Utils.xorMyColor(v);
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                playSound(v);
            }
            return true;
        }
    };

    private void playSound(View v) {
        if(v == topRight) soundPool.play(sound1, 1, 1, 1, 0, 0);
        if(v == topLeft) soundPool.play(sound2, 1, 1, 1, 0, 0);
        if(v == bottomLeft) soundPool.play(sound3, 1, 1, 1, 0, 0);
        if(v == bottomRight) soundPool.play(sound4, 1, 1, 1, 0, 0);
    }
}
