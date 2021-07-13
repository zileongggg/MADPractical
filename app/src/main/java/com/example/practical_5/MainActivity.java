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
        mySQLiteAdapter.insert("Nasi Lemak", "Rice", 10);
        mySQLiteAdapter.insert("Roti Canai", "Flour", 1);
        mySQLiteAdapter.insert("Char Kuey Tiao", "Kuey Tiao", 6);
        mySQLiteAdapter.insert("Kuih Nyonya", "Pandan", 2);
        mySQLiteAdapter.insert("Ulam", "Vege", 12);
        mySQLiteAdapter.insert("Nasi Kandar", "Rice", 10);
        mySQLiteAdapter.insert("Curry Laksa", "Noodles", 21);
        mySQLiteAdapter.close();

        // open to read
        mySQLiteAdapter.openToRead();
        String contentRead = mySQLiteAdapter.queueMultipleColumn();
        mySQLiteAdapter.close();

        listContent.setText(contentRead);
        ll.addView(listContent);
        setContentView(ll);

    }
}
