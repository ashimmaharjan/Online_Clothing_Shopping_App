package com.example.onlineshopping;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter <ItemsAdapter.ItemsViewHolder>
{

    List<Items> itemsList;
    Context context;

    public ItemsAdapter(List<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview,viewGroup,false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {

        Items items=itemsList.get(i);
        itemsViewHolder.iName.setText(items.getItemName());
        itemsViewHolder.iPrice.setText(items.getItemPrice());
        itemsViewHolder.iImage.setImageResource(items.getItemImage());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ItemsViewHolder extends RecyclerView.ViewHolder
    {
        TextView iName,iPrice;
        ImageView iImage;


        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            iName=itemView.findViewById(R.id.itemName);
            iPrice=itemView.findViewById(R.id.itemPrice);
            iImage=itemView.findViewById(R.id.itemImage);
        }
    }


}
