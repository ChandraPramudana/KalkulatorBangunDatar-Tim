package com.example.modul2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText angka1, angka2, hasil;
    private Button buttontambah, buttonkurang, buttonbagi, buttonkali, buttonclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan elemen UI dengan variabel
        angka1 = findViewById(R.id.angka1);
        angka2 = findViewById(R.id.angka2);
        hasil = findViewById(R.id.hasil);
        hasil.setEnabled(false); // Membuat EditText hasil tidak dapat diedit

        buttontambah = findViewById(R.id.buttontambah);
        buttonkurang = findViewById(R.id.buttonkurang);
        buttonbagi = findViewById(R.id.buttonbagi);
        buttonkali = findViewById(R.id.buttonkali);
        buttonclear = findViewById(R.id.buttonclear);

        // Fungsi untuk setiap operasi aritmatika
        buttontambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        buttonkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        buttonbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });

        buttonkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angka1.setText("");
                angka2.setText("");
                hasil.setText("");
            }
        });
    }

    // Metode untuk melakukan perhitungan
    private void hitung(char operasi) {
        String inputAngka1 = angka1.getText().toString();
        String inputAngka2 = angka2.getText().toString();

        // Memeriksa apakah input tidak kosong
        if (TextUtils.isEmpty(inputAngka1) || TextUtils.isEmpty(inputAngka2)) {
            Toast.makeText(this, "Masukkan kedua angka", Toast.LENGTH_SHORT).show();
            return;
        }

        // Mengonversi input menjadi angka desimal
        double angkaPertama = Double.parseDouble(inputAngka1);
        double angkaKedua = Double.parseDouble(inputAngka2);
        double hasilPerhitungan = 0;

        // Melakukan operasi berdasarkan tombol yang ditekan
        switch (operasi) {
            case '+':
                hasilPerhitungan = angkaPertama + angkaKedua;
                break;
            case '-':
                hasilPerhitungan = angkaPertama - angkaKedua;
                break;
            case '/':
                if (angkaKedua != 0) {
                    hasilPerhitungan = angkaPertama / angkaKedua;
                } else {
                    Toast.makeText(this, "Tidak dapat membagi dengan nol", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case '*':
                hasilPerhitungan = angkaPertama * angkaKedua;
                break;
        }

        // Menampilkan hasil perhitungan
        hasil.setText(String.valueOf(hasilPerhitungan));
    }
}

