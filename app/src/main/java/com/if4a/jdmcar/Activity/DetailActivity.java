package com.if4a.jdmcar.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.if4a.jdmcar.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private TextView tvNama,tvProdusen,tvMasaProduksi,tvSejarah;
    private ImageView ivGambar;
    private String nama,produsen,masaProduksi,sejarah,gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNama = findViewById(R.id.tv_nama);
        tvProdusen = findViewById(R.id.tv_produsen);
        tvMasaProduksi = findViewById(R.id.tv_masa_produksi);
        tvSejarah =findViewById(R.id.tv_sejarah);
        ivGambar = findViewById(R.id.iv_gambar);

        Intent intent = getIntent();
        nama = intent.getStringExtra("xNama");
        produsen = intent.getStringExtra("xProdusen");
        masaProduksi = intent.getStringExtra("xMasaProduksi");
        sejarah = intent.getStringExtra("xSejarah");
        gambar = intent.getStringExtra("xGambar");

        tvNama.setText(nama);
        tvProdusen.setText(produsen);
        tvMasaProduksi.setText(masaProduksi);
        tvSejarah.setText(sejarah);
        Picasso.get().load(gambar).into(ivGambar);

    }
}