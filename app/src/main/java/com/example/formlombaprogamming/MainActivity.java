package com.example.formlombaprogamming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
{

    private EditText etNama, etNoWhatsApp, etALamat, etPassword, etPin;
    private RadioGroup rgJenisKelamin;
    private RadioButton rbJenisKelamin;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNoWhatsApp = findViewById(R.id.et_no_whatsapp);
        etALamat = findViewById(R.id.et_alamat);
        etPassword = findViewById(R.id.et_password);
        etPin = findViewById(R.id.et_pin);
        rgJenisKelamin = findViewById(R.id.rg_jk);
        btnDaftar = findViewById(R.id.btn_daftar);

        btnDaftar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String nama  = etNama.getText().toString();
                String noWhatsApp = etNoWhatsApp.getText().toString();
                String alamat = etALamat.getText().toString();
                String password = etPassword.getText().toString();
                String pin = etPin.getText().toString();

                int jenisKelaminID = rgJenisKelamin.getCheckedRadioButtonId();
                rbJenisKelamin = findViewById(jenisKelaminID);

                String jenisKelamin = rbJenisKelamin.getText().toString();

                if(nama.trim().equals(""))
                {
                 etNama.setError("Nama tidak boleh kosong!!!!");
                }
                else if(noWhatsApp.trim().equals(""))
                {
                    etNoWhatsApp.setError("No Whatsapp tidak boleh kosong!!!!");
                }
                else if(alamat.trim().equals(""))
                {
                    etALamat.setError("Alamat tidak boleh kosong!!!!");
                }
                else if(password.trim().equals(""))
                {
                    etPassword.setError("Password tidak boleh kosong!!!!");
                }
                else if(pin.trim().equals(""))
                {
                    etPin.setError("PIN tidak boleh kosong!!!!");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, ConfirmActivity.class);
                    intent.putExtra("varNama",nama);
                    intent.putExtra("varNowa",noWhatsApp);
                    intent.putExtra("varAlamat",alamat);
                    intent.putExtra("varjenisKelamin",jenisKelamin);
                    startActivity(intent);
                    
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        etNama.setText("");
        etPassword.setText("");
        etPin.setText("");
        etALamat.setText("");
        etNoWhatsApp.setText("");


    }
}