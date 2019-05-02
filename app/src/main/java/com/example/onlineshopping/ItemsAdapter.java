package com.example.onlineshopping;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter
{

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
