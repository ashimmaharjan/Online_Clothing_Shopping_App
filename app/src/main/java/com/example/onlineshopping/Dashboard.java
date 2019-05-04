package com.example.onlineshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.List;


public class Dashboard extends AppCompatActivity implements ItemsAdapter.OnItemListener {

    TextView displayUsername;
    Button btnLogout;
    String dUsername,iName,iPrice,iDesc;
    private RecyclerView recyclerView;
    List<Items> itemsList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        displayUsername=findViewById(R.id.getUsername);
        btnLogout=findViewById(R.id.logout);

        dUsername=getIntent().getStringExtra("USERNAME");
        displayUsername.setText(dUsername);

        recyclerView=findViewById(R.id.recyclerView);

        prepareItemsList();
        recyclerView.setAdapter(new ItemsAdapter(itemsList,getApplicationContext(),this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logout=new Intent(Dashboard.this,MainActivity.class);
                startActivity(logout);
            }
        });
    }
    public void prepareItemsList()
    {
        itemsList.add(new Items("shirt","Rs. 2000",R.drawable.kakashi,"Full Sleeve Shirt"));
        itemsList.add(new Items("t-shirt","Rs. 1500",R.drawable.tg,"Half Sleeve"));
    }

    @Override
    public void onItemClick(int position) {

        iName=itemsList.get(position).getItemName();
        iPrice=itemsList.get(position).getItemPrice();
        iDesc=itemsList.get(position).getItemDesc();
        Intent openDescription=new Intent(Dashboard.this,DisplayClickedItem.class);
        openDescription.putExtra("name",iName);
        openDescription.putExtra("price",iPrice);
        openDescription.putExtra("desc",iDesc);
        startActivity(openDescription);
    }
}
