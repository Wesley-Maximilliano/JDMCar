package com.if4a.jdmcar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if4a.jdmcar.Model.ModelJDM;
import com.if4a.jdmcar.R;

import java.util.List;

public class AdapterJDM extends RecyclerView.Adapter<AdapterJDM.VHJdm>{
    private Context ctx;
    private List<ModelJDM> listJdm;

    public AdapterJDM(Context ctx, List<ModelJDM> listJdm) {
        this.ctx = ctx;
        this.listJdm = listJdm;
    }

    @NonNull
    @Override
    public VHJdm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.list_item_jdm,parent,false);
        return new VHJdm(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull VHJdm holder, int position) {
        ModelJDM MJ = listJdm.get(position);

        holder.tvId.setText(MJ.getId());
        holder.tvNama.setText(MJ.getNama_mobil());
        holder.tvProdusen.setText(MJ.getProdusen());
        holder.tvMasaProduksi.setText(MJ.getMasa_produksi());
        holder.tvSejarah.setText(MJ.getSejarah());
        holder.tvGambar.setText(MJ.getGambar());
    }

    @Override
    public int getItemCount() {
        return listJdm.size();
    }

    public class VHJdm extends RecyclerView.ViewHolder{

        TextView tvId, tvNama, tvProdusen, tvMasaProduksi, tvSejarah, tvGambar;

        public VHJdm(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvProdusen = itemView.findViewById(R.id.tv_produsen);
            tvMasaProduksi = itemView.findViewById(R.id.tv_masa_produksi);
            tvSejarah = itemView.findViewById(R.id.tv_sejarah);
            tvGambar = itemView.findViewById(R.id.tv_gambar);

        }
    }
}
