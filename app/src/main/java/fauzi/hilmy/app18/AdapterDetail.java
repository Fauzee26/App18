package fauzi.hilmy.app18;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.MyViewHolder> {
    private Context context;
    private ArrayList<Poison> listPoison;

    public AdapterDetail(Context context) {
        this.context = context;
    }

    public ArrayList<Poison> getListPoison() {
        return listPoison;
    }

    public void setListPoison(ArrayList<Poison> listPoison) {
        this.listPoison = listPoison;
    }

    @NonNull
    @Override
    public AdapterDetail.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDetail.MyViewHolder holder, final int position) {
        Picasso.with(context)
                .load(getListPoison().get(position).getPhoto())
                .resize(150, 150)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_shirt);
                TextView txtNama = dialog.findViewById(R.id.txtNama);
                TextView txtDeskripsi = dialog.findViewById(R.id.txtDeskripsi);
                ImageView imagee = dialog.findViewById(R.id.imageModel);
                txtNama.setText(getListPoison().get(position).getNama());
                txtDeskripsi.setText(getListPoison().get(position).getDescription());

                Picasso.with(context)
                        .load(getListPoison().get(position).getPhoto())
                        .resize(150, 150)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(imagee);

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListPoison().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
