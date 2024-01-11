package ru.romanivanov.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        if (Locale.getDefault().getLanguage().equals("en")) {
            imageView.setImageResource(R.drawable.liberty_state);
        }
        else if (Locale.getDefault().getLanguage().equals("ru")) {
            imageView.setImageResource(R.drawable.church);
        }
    }
}