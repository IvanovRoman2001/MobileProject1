package ru.romanivanov.lab16;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private AssetManager assetManager;

    private int catSound = 0;
    private int chickenSound = 0;
    private int cowSound = 0;
    private int dogSound = 0;
    private int duckSound = 0;
    private int sheepSound = 0;

    private int streamID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView catImage = findViewById(R.id.image_cat);
        ImageView chickenImage = findViewById(R.id.image_chicken);
        ImageView cowImage = findViewById(R.id.image_cow);
        ImageView dogImage = findViewById(R.id.image_dog);
        ImageView duckImage = findViewById(R.id.image_duck);
        ImageView sheepImage = findViewById(R.id.image_sheep);

        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();

        assetManager = getAssets();
        catSound = loadSound("cat_voice.ogg");
        chickenSound = loadSound("chicken_voice.ogg");
        cowSound = loadSound("cow_voice.ogg");
        dogSound = loadSound("dog_voice.ogg");
        duckSound = loadSound("duck_voice.ogg");
        sheepSound = loadSound("sheep_voice.ogg");

        catImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(catSound);
            }
        });
        chickenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(chickenSound);
            }
        });
        cowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(cowSound);
            }
        });
        dogImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(dogSound);
            }
        });
        duckImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(duckSound);
            }
        });
        sheepImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(sheepSound);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        soundPool.release();
    }

    private int playSound(int sound) {
        if (sound > 0) {
            streamID = soundPool.play(sound, 1F, 1F, 1, 0, 1F);
        }
        return streamID;
    }

    private int loadSound(String fileName) {
        try {
            AssetFileDescriptor afd = assetManager.openFd(fileName);
            return soundPool.load(afd, 1);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Meow", "Не могу загрузить файл " + fileName);
            return -1;
        }
    }
}