package com.example.lr_9;

import static android.graphics.Color.parseColor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        findViewById(R.id.text_view).setOnCreateContextMenuListener(this);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.preferences) {
            Toast.makeText(this, "первое", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p1);
            return true;
        } else if (itemId == R.id.second) {
            Toast.makeText(this, "второе", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p2);
            return true;
        } else if (itemId == R.id.home) {
            Toast.makeText(this, "третье", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.p3);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, 1, 0, "Повернуть по часовой стрелке");
        menu.add(1, 2, 1, "Повернуть против часовой стрелки");
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                imageView.setRotation(imageView.getRotation()+90);
                return true;
            case 2:
                imageView.setRotation(imageView.getRotation()-90);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}