package com.example.onlineshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayClickedItem extends AppCompatActivity {

    ImageView itemImage;
    TextView itemName,itemPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_clicked_item);

        itemImage=findViewById(R.id.displayItemImage);
        itemName=findViewById(R.id.displayItemName);
        itemPrice=findViewById(R.id.displayItemPrice);

        Bundle bundle=getIntent().getExtras();

        if(bundle != null)
        {
            itemImage.setImageResource(bundle.getInt("image"));
            itemName.setText(bundle.getString("name"));
            itemPrice.setText(bundle.getString("price"));
        }
    }
}
