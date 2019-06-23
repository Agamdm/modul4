package com.example.modul4alfan;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;


public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{
    private ArrayList<Menu> dataList;
    public Context context;



    public MenuAdapter(Context context, ArrayList<Menu> dataList){
        this.dataList = dataList;
        this.context = context;
    }
    @Override
    public MenuViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardviewmenu, parent, false);
        return new MenuViewHolder(view);
    }
    @Override
    public void onBindViewHolder (MenuViewHolder holder, final int position){
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.imageMenu.setImageResource(dataList.get(position).getImage());
        holder.harga.setText(Integer.toString(dataList.get(position).getHarga()));

        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, addOrder.class);
                intent.putExtra("choose", dataList.get(position).getId());
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount(){
        return (dataList != null) ? dataList.size() : 0;
    }
    public class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, harga;
        private ImageView imageMenu;
        private RelativeLayout relative;

        public MenuViewHolder(View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.txt_nama_menu);
            imageMenu = itemView.findViewById(R.id.image_menu);
            harga = itemView.findViewById(R.id.price);
            relative = itemView.findViewById(R.id.rel_layout);

        }

    }

}
