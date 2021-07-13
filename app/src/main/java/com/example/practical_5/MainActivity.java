package com.example.practical_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SQLiteAdapter mySQLiteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView listContent = new TextView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        listContent.setTextSize(20f);

        mySQLiteAdapter = new SQLiteAdapter(this);

        // open to write
        mySQLiteAdapter.openToWrite();
        mySQLiteAdapter.deleteAll();
        mySQLiteAdapter.insert("Burger");
        mySQLiteAdapter.insert("Nasi Lemak");
        mySQLiteAdapter.insert("Ayam Goreng");
        mySQLiteAdapter.insert("Curry Laksa");
        mySQLiteAdapter.insert("KFC");
        mySQLiteAdapter.close();

        // open to read
        mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queueAll();
        mySQLiteAdapter.close();

        listContent.setText(contentRead);
        ll.addView(listContent);
        setContentView(ll);

    }
}
