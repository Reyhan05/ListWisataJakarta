package reyhan.com.listwisatajakarta;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemWisataAdapter extends RecyclerView.Adapter<ItemWisataAdapter.WisataViewHolder> {
    private ArrayList<WisataModel> listWisata;
    private Context context;

    public ItemWisataAdapter(ArrayList<WisataModel> list, Context context) {
        this.listWisata = list;
        this.context = context;


    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata_row, parent, false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WisataViewHolder holder, int position) {
        WisataModel wisataModel = listWisata.get(position);

        holder.tvNamaWisata.setText(wisataModel.getNamaWisata());
        holder.tvLokasiWisata.setText(wisataModel.getNamaLokasiWisata());
        holder.tvDescWisata.setText(wisataModel.getDescWisata());
        Picasso.get().load(wisataModel.getGambarWisata()).into(holder.ivGambar);

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Favorite" + listWisata.get(holder.getAdapterPosition()).getNamaWisata(), Toast.LENGTH_LONG).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Share" + listWisata.get(holder.getAdapterPosition()).getNamaWisata());
                sendIntent.setType("text/plain");
                context.startActivity(sendIntent);
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailWisataActivity.class);
                intent.putExtra("putNamaWisata", listWisata.get(holder.getAdapterPosition()).getNamaWisata());
                intent.putExtra("putLokasiWisata", listWisata.get(holder.getAdapterPosition()).getNamaLokasiWisata());
                intent.putExtra("putDescWisata", listWisata.get(holder.getAdapterPosition()).getDescWisata());
                intent.putExtra("putGambarWisata", listWisata.get(holder.getAdapterPosition()).getGambarWisata());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class WisataViewHolder extends RecyclerView.ViewHolder {
        Button btnShare, btnFavorite;
        ImageView ivGambar;
        TextView tvNamaWisata, tvLokasiWisata, tvDescWisata;

        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);

            ivGambar = itemView.findViewById(R.id.ivWisata);
            tvNamaWisata = itemView.findViewById(R.id.tvNamaWisata);
            tvDescWisata = itemView.findViewById(R.id.tvDescTeam);
            tvLokasiWisata = itemView.findViewById(R.id.tvLokasiWisata);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);
            btnShare = itemView.findViewById(R.id.btn_Share);
        }
    }

}
