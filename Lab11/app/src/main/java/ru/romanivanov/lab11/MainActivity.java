package ru.romanivanov.lab11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        TextView infoTextView = findViewById(R.id.textView);

        // Операции для выбранного пункта меню
        while (true) {
            if (id == R.id.action_cat1) {
                infoTextView.setText("Вы выбрали кота!");
                return true;
            }
            else if (id == R.id.action_cat2) {
                infoTextView.setText("Вы выбрали кошку!");
                return true;
            }
            else if (id == R.id.action_cat3) {
                infoTextView.setText("Вы выбрали котёнка!");
                return true;
            }
            else {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}