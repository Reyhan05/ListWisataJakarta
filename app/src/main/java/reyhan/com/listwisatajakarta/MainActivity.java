package reyhan.com.listwisatajakarta;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvWisata;
    ArrayList<WisataModel> wisataModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWisata = findViewById(R.id.rvWisata);
        rvWisata.setHasFixedSize(true);

        wisataModels.addAll(WisataData.getListDataWisata());
        setRecycleView();

    }

    private void setRecycleView() {
        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ItemWisataAdapter itemWisataAdapter = new ItemWisataAdapter(wisataModels, this);
        rvWisata.setAdapter(itemWisataAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            startActivity(new Intent(MainActivity.this, DetailAccountActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }
}
