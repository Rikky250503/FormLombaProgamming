package com.example.formlombaprogamming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity
{
    DatePickerDialog datePickerDialog;
    TextView tvNama, tvJk, tvNoWhatsapp, tvAlamat, tvTanggal;
    Button btnTanggal, btnKonfirmasi;

    String nama, jk, noWhatsapp, alamat, choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tvNama = findViewById(R.id.tv_nama);
        tvJk = findViewById(R.id.tv_jk);
        tvNoWhatsapp = findViewById(R.id.tv_no_wa);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvTanggal = findViewById(R.id.tv_tanggal);

        btnTanggal = findViewById(R.id.btn_tanggal);
        btnKonfirmasi = findViewById(R.id.btn_konfirmasi);

        //ambil Intent yang di kirim oleh MainActivity

        Intent terima = getIntent();
        nama = terima.getStringExtra("varNama");
        noWhatsapp = terima.getStringExtra("varNowa");
        alamat = terima.getStringExtra("varAlamat");
        jk = terima.getStringExtra("varjenisKelamin");
       // set variabel

        tvNama.setText(nama);
        tvJk.setText(jk);
        tvAlamat.setText(alamat);
        tvNoWhatsapp.setText(noWhatsapp);

        btnTanggal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Calendar newCalendar = Calendar.getInstance();
                datePickerDialog = new DatePickerDialog(ConfirmActivity.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day)
                    {
                        String tahun = Integer.toString(year);
                        String bulan = Integer.toString(month + 1);
                        String tanggal = Integer.toString(day);

                        choosenDate = tanggal + "/" + bulan + "/" + tahun;
                        tvTanggal.setText(choosenDate);
                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

                // tampilkan datePicker dialog
                datePickerDialog.show();

            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ConfirmActivity.this);
                dialog.setTitle("Perhatian");
                dialog.setMessage("Apakah data Anda sudah benar?");

                // Button positif

                dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(ConfirmActivity.this,"Terima kasih, Pendaftaran Anda berhasil.",
                                Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                // button negatif
                dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                    }
                });
                // tampilkan dialog
                dialog.show();

            }
        });

    }
}