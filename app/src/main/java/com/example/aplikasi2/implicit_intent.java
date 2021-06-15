package com.example.aplikasi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class implicit_intent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        final EditText et = findViewById(R.id.etNo);

        //set click listener untuk camera button
        findViewById(R.id.btnKontak).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://contacts/people"));
            startActivity(intent);
        });
        //set click gelery
        findViewById(R.id.btnGaleri).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://media/internal/images/media"));
            startActivity(intent);
        });
        //set browser
        findViewById(R.id.btnBrowser).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.com/"));
            startActivity(intent);
        });

        //click phone
        findViewById(R.id.btnPhone).setOnClickListener(v -> {

            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:"+et.getText()));
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:"+et.getText()));
            startActivity(i);

            startActivity(new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:"+et.getText())));

        });
        //click folder
        findViewById(R.id.btnFolder).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://media/internal/document/media"));
            startActivity(intent);
        });
    }
}