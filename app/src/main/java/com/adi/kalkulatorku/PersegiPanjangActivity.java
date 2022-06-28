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

public class PersegiPanjangActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView autoCompleteTextView;
    Button btnHitung;
    TextInputEditText edtPanjang, edtLebar;
    TextView tvHasil,tvPerhitunganHasil;
    TextInputLayout edtPanjangLayout, edtLebarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        tvPerhitunganHasil = findViewById(R.id.tv_perhitungan_hasil);
        edtPanjang = findViewById(R.id.edt_panjang);
        edtLebar = findViewById(R.id.edt_lebar);
        edtPanjangLayout = findViewById(R.id.edt_panjang_layout);
        edtLebarLayout = findViewById(R.id.edt_lebar_layout);

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
            String panjang = edtPanjang.getText().toString().trim();
            String lebar = edtLebar.getText().toString().trim();

            boolean isEmptyFields = false;

            if(panjang.isEmpty()){
                isEmptyFields = true;
                edtPanjang.setError("Field ini tidak boleh kosong");
            }

            if(lebar.isEmpty()){
                isEmptyFields = true;
                edtLebar.setError("Field ini tidak boleh kosong");
            }

            if(!isEmptyFields){
                if (autoCompleteTextView.getText().toString().equals("Keliling")){
                    tvPerhitunganHasil.setText("Keliling Persegi Panjang");
                    tvHasil.setText(String.valueOf((Double.parseDouble(panjang)+Double.parseDouble(lebar))*2));
                } else if (autoCompleteTextView.getText().toString().equals("Luas")){
                    tvPerhitunganHasil.setText("Luas Persegi Panjang");
                    tvHasil.setText(String.valueOf(Double.parseDouble(panjang)*Double.parseDouble(lebar)));
                }
            }
        }
    }
}