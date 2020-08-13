package reyhan.com.listwisatajakarta;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailWisataActivity extends AppCompatActivity {

    TextView tvDescWisata, tvLokasiWisata, tvNamaWisata;
    ImageView ivgambar;

    String namaWisata, lokasiWisata, descWisata, gambarWisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDescWisata = findViewById(R.id.tv_DescWisata);
        tvLokasiWisata = findViewById(R.id.tv_LokasiWisata);
        tvNamaWisata = findViewById(R.id.tv_NameDetailWisata);
        ivgambar = findViewById(R.id.iv_GambarWisata);

        Intent intent = getIntent();
        namaWisata = intent.getStringExtra("putNamaWisata");
        lokasiWisata = intent.getStringExtra("putLokasiWisata");
        descWisata = intent.getStringExtra("putDescWisata");
        gambarWisata = intent.getStringExtra("putGambarWisata");

        tvNamaWisata.setText(namaWisata);
        tvLokasiWisata.setText(lokasiWisata);
        tvDescWisata.setText(descWisata);
        Picasso.get().load(gambarWisata).into(ivgambar);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();

        }
        return super.onOptionsItemSelected(item);

    }
}
