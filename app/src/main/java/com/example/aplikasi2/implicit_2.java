package com.example.aplikasi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class implicit_2 extends AppCompatActivity {
    Button btnshare,btnAlarm,btnFoto;
    EditText etjam,etmnt,etdesk;
    ImageView imageView;
    final int REQUEST_CODE = 111;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_2);

        btnshare = findViewById(R.id.btnShare);
        btnFoto = findViewById(R.id.btnfoto);
        imageView = findViewById(R.id.hslfoto);

        //Onclick button share
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Praktikum Mobile Implicit Intent");
                startActivity(intent.createChooser(intent,"Share"));
            }
        });

        etjam = findViewById(R.id.jam);
        etmnt = findViewById(R.id.mnt);
        etdesk = findViewById(R.id.desk);

        btnAlarm = findViewById(R.id.btnalarm);
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int jam = Integer.parseInt(etjam.getText().toString());
                int menit = Integer.parseInt(etmnt.getText().toString());
                String desc = String.valueOf(etdesk.getText());

                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, jam);
                intent.putExtra(AlarmClock.EXTRA_MINUTES, menit);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,desc);

                if (jam <= 24 && menit <= 60)
                {
                    startActivity(intent);
                } else
                    Toast.makeText(getApplicationContext(), "Waktu Salah", Toast.LENGTH_SHORT).show();
            }
        });

        btnFoto = findViewById(R.id.btnfoto);
        imageView = findViewById(R.id.hslfoto);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }


}