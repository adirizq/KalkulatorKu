package com.adi.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LingkaranActivity extends AppCompatActivity implements View.OnClickListener {
    AutoCompleteTextView autoCompleteTextView;
    Button btnHitung;
    TextInputEditText edtJari;
    TextView tvHasil,tvPerhitunganHasil;
    TextInputLayout edtJariLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        tvPerhitunganHasil = findViewById(R.id.tv_perhitungan_hasil);
        edtJari = findViewById(R.id.edt_jari);
        edtJariLayout = findViewById(R.id.edt_jari_layout);

        tvPerhitunganHasil.setText("");
        tvHasil.setText("");

        String []option = {"Keliling", "Luas"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_item, option);

        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);

        autoCompleteTextView.setAdapter(arrayAdapter);

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_hitung){
            String jari = edtJari.getText().toString().trim();

            if(jari.isEmpty()){
                edtJari.setError("Field ini tidak boleh kosong");
            } else {
                if (autoCompleteTextView.getText().toString().equals("Keliling")){
                    tvPerhitunganHasil.setText("Keliling Lingkaran");
                    tvHasil.setText(String.valueOf(3.14159 * 2 * Double.parseDouble(jari)));
                } else if (autoCompleteTextView.getText().toString().equals("Luas")){
                    tvPerhitunganHasil.setText("Luas Lingkaran");
                    tvHasil.setText(String.valueOf(3.14159 * Double.parseDouble(jari) * Double.parseDouble(jari)));
                }
            }
        }
    }
}