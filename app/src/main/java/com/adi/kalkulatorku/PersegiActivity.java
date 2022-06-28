package com.adi.kalkulatorku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class PersegiActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView autoCompleteTextView;
    Button btnHitung;
    TextInputEditText edtSisi;
    TextView tvHasil,tvPerhitunganHasil;
    TextInputLayout edtSisiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        btnHitung = findViewById(R.id.btn_hitung);
        edtSisi = findViewById(R.id.sisi);
        tvHasil = findViewById(R.id.tv_hasil);
        tvPerhitunganHasil = findViewById(R.id.tv_perhitungan_hasil);
        edtSisiLayout = findViewById(R.id.edt_sisi);

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
            String sisi = edtSisi.getText().toString().trim();

            if(sisi.isEmpty()){
                edtSisi.setError("Field ini tidak boleh kosong");
            } else {
                if (autoCompleteTextView.getText().toString().equals("Keliling")){
                    tvPerhitunganHasil.setText("Keliling Persegi");
                    tvHasil.setText(String.valueOf(Double.parseDouble(sisi)*4));
                } else if (autoCompleteTextView.getText().toString().equals("Luas")){
                    tvPerhitunganHasil.setText("Luas Persegi");
                    tvHasil.setText(String.valueOf(Double.parseDouble(sisi)*Double.parseDouble(sisi)));
                }
            }
        }
    }
}