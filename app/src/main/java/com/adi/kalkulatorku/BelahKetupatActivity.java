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

public class BelahKetupatActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView autoCompleteTextView;
    Button btnHitung;
    TextView tvHasil,tvPerhitunganHasil;
    TextInputEditText edtSisi, edtDiagonal1, edtDiagonal2;
    TextInputLayout edtSisiLayout, edtDiagonal1Layout, edtDiagonal2Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);

        autoCompleteTextView = findViewById(R.id.autoCompleteText);
        btnHitung = findViewById(R.id.btn_hitung);
        tvHasil = findViewById(R.id.tv_hasil);
        tvPerhitunganHasil = findViewById(R.id.tv_perhitungan_hasil);
        edtSisi = findViewById(R.id.edt_sisi);
        edtDiagonal1 = findViewById(R.id.edt_diagonal_1);
        edtDiagonal2 = findViewById(R.id.edt_diagonal_2);
        edtSisiLayout = findViewById(R.id.edt_sisi_layout);
        edtDiagonal1Layout = findViewById(R.id.edt_diagonal_1_layout);
        edtDiagonal2Layout = findViewById(R.id.edt_diagonal_2_layout);

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
                    edtSisiLayout.setVisibility(View.GONE);
                    edtDiagonal1Layout.setVisibility(View.VISIBLE);
                    edtDiagonal2Layout.setVisibility(View.VISIBLE);
                } else if (autoCompleteTextView.getText().toString().equals("Keliling")){
                    edtDiagonal1Layout.setVisibility(View.GONE);
                    edtDiagonal2Layout.setVisibility(View.GONE);
                    edtSisiLayout.setVisibility(View.VISIBLE);
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
            String sisi = edtSisi.getText().toString().trim();
            String diagonal1 = edtDiagonal1.getText().toString().trim();
            String diagonal2 = edtDiagonal2.getText().toString().trim();

            if(autoCompleteTextView.getText().toString().equals("Keliling")){
                if(sisi.isEmpty()){
                    edtSisi.setError("Field ini tidak boleh kosong");
                } else {
                    tvPerhitunganHasil.setText("Keliling Belah Ketupat");
                    tvHasil.setText(String.valueOf(Double.parseDouble(sisi) * 4));
                }
            } else if(autoCompleteTextView.getText().toString().equals("Luas")){
                boolean isEmptyFields = false;

                if(diagonal1.isEmpty()){
                    isEmptyFields = true;
                    edtDiagonal1.setError("Field ini tidak boleh kosong");
                }

                if(diagonal2.isEmpty()){
                    isEmptyFields = true;
                    edtDiagonal2.setError("Field ini tidak boleh kosong");
                }

                if(!isEmptyFields){
                    tvPerhitunganHasil.setText("Luas Belah Ketupat");
                    tvHasil.setText(String.valueOf(0.5 * Double.parseDouble(diagonal1) * Double.parseDouble(diagonal2)));
                }
            }
        }
    }
}