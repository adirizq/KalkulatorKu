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

public class JajarGenjangActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView autoCompleteTextView;
    Button btnHitung;
    TextInputEditText edtSisiA, edtSisiB, edtTinggi;
    TextView tvHasil,tvPerhitunganHasil;
    TextInputLayout edtSisiALayout, edtSisiBLayout, edtTinggiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajar_genjang);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        tvPerhitunganHasil = findViewById(R.id.tv_perhitungan_hasil);
        edtSisiA = findViewById(R.id.edt_sisi_a);
        edtSisiB = findViewById(R.id.edt_sisi_b);
        edtTinggi = findViewById(R.id.edt_tinggi);
        edtSisiALayout = findViewById(R.id.edt_sisi_a_layout);
        edtSisiBLayout = findViewById(R.id.edt_sisi_b_layout);
        edtTinggiLayout = findViewById(R.id.edt_tinggi_layout);

        tvPerhitunganHasil.setText("");
        tvHasil.setText("");

        String []option = {"Keliling", "Luas"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_item, option);

        autoCompleteTextView.setText(arrayAdapter.getItem(0).toString(), false);

        autoCompleteTextView.setAdapter(arrayAdapter);

        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (autoCompleteTextView.getText().toString().equals("Luas")){
                    edtSisiBLayout.setVisibility(View.GONE);
                    edtTinggiLayout.setVisibility(View.VISIBLE);
                } else if (autoCompleteTextView.getText().toString().equals("Keliling")){
                    edtTinggiLayout.setVisibility(View.GONE);
                    edtSisiBLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnHitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_hitung){
            String sisiA = edtSisiA.getText().toString().trim();
            String sisiB = edtSisiB.getText().toString().trim();
            String tinggi = edtTinggi.getText().toString().trim();

            if(autoCompleteTextView.getText().toString().equals("Keliling")){
                boolean isEmptyFields = false;

                if(sisiA.isEmpty()){
                    isEmptyFields = true;
                    edtSisiA.setError("Field ini tidak boleh kosong");
                }

                if(sisiB.isEmpty()){
                    isEmptyFields = true;
                    edtSisiB.setError("Field ini tidak boleh kosong");
                }

                if(!isEmptyFields){
                    tvPerhitunganHasil.setText("Keliling Jajar Genjang");
                    tvHasil.setText(String.valueOf(2*(Double.parseDouble(sisiA) + Double.parseDouble(sisiB))));
                }
            } else if(autoCompleteTextView.getText().toString().equals("Luas")){
                boolean isEmptyFields2 = false;

                if(sisiA.isEmpty()){
                    isEmptyFields2 = true;
                    edtSisiA.setError("Field ini tidak boleh kosong");
                }

                if(tinggi.isEmpty()){
                    isEmptyFields2 = true;
                    edtTinggi.setError("Field ini tidak boleh kosong");
                }

                if(!isEmptyFields2){
                    tvPerhitunganHasil.setText("Luas Jajar Genjang");
                    tvHasil.setText(String.valueOf(Double.parseDouble(sisiA) * Double.parseDouble(tinggi)));
                }
            }
        }
    }
}