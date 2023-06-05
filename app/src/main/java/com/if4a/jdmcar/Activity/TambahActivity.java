package com.if4a.jdmcar.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.if4a.jdmcar.API.APIRequestData;
import com.if4a.jdmcar.API.RetroServer;
import com.if4a.jdmcar.Model.ModelResponse;
import com.if4a.jdmcar.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etProdusen, etMasaProduksi, etSejarah, etGambar;
    private Button btnTambah;
    private String nama,produsen,masaProduksi,sejarah,gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etProdusen = findViewById(R.id.et_produsen);
        etMasaProduksi = findViewById(R.id.et_masa_produksi);
        etSejarah = findViewById(R.id.et_sejarah);
        etGambar = findViewById(R.id.et_gambar);
        btnTambah = findViewById(R.id.btn_tambah);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama =etNama.getText().toString();
                produsen = etProdusen.getText().toString();
                masaProduksi = etMasaProduksi.getText().toString();
                sejarah = etSejarah.getText().toString();
                gambar = etGambar.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama tidak boleh kosong!!!");
                }
                else if (produsen.trim().equals("")) {
                    etProdusen.setError("Produsen tidak boleh Kosong !!!");
                }
                else if (masaProduksi.trim().equals("")) {
                    etMasaProduksi.setError("Masa Produksi tidak Boleh Kosong !!!");
                }
                else if (sejarah.trim().equals("")) {
                    etSejarah.setError("Sejarah Tidak Boleh Kosong !!!");
                }
                else {
                   tambahJdm();
                }

            }
        });
    }

    private void tambahJdm(){
        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = ARD.ardCreate(nama,produsen,masaProduksi,sejarah,gambar);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();


                Toast.makeText(TambahActivity.this, "Kode : " + kode +"Pesan: " + pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}