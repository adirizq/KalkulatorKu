package com.adi.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPersegi = findViewById(R.id.btn_persegi);
        Button btnPersegiPanjang = findViewById(R.id.btn_persegi_panjang);
        Button btnJajarGenjang = findViewById(R.id.btn_jajar_genjang);
        Button btnSegitiga = findViewById(R.id.btn_segitiga);
        Button btnBelahKetupat = findViewById(R.id.btn_belah_ketupat);
        Button btnLingkaran = findViewById(R.id.btn_lingkaran);


        btnPersegi.setOnClickListener(this);
        btnPersegiPanjang.setOnClickListener(this);
        btnJajarGenjang.setOnClickListener(this);
        btnSegitiga.setOnClickListener(this);
        btnBelahKetupat.setOnClickListener(this);
        btnLingkaran.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_persegi){
            Intent persegiIntent = new Intent(MainActivity.this, PersegiActivity.class);
            startActivity(persegiIntent);
        } else if(v.getId() == R.id.btn_persegi_panjang){
            Intent persegiPanjangIntent = new Intent(MainActivity.this, PersegiPanjangActivity.class);
            startActivity(persegiPanjangIntent);
        } else if(v.getId() == R.id.btn_jajar_genjang){
            Intent jajarGenjangIntent = new Intent(MainActivity.this, JajarGenjangActivity.class);
            startActivity(jajarGenjangIntent);
        } else if(v.getId() == R.id.btn_segitiga) {
            Intent segitigaIntent = new Intent(MainActivity.this, SegitigaActivity.class);
            startActivity(segitigaIntent);
        } else if(v.getId() == R.id.btn_belah_ketupat) {
            Intent belahKetupatIntent = new Intent(MainActivity.this, BelahKetupatActivity.class);
            startActivity(belahKetupatIntent);
        } else if(v.getId() == R.id.btn_lingkaran) {
            Intent lingkaranIntent = new Intent(MainActivity.this, LingkaranActivity.class);
            startActivity(lingkaranIntent);
        }
    }
}