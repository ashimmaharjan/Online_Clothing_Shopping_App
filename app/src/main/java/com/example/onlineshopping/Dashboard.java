package com.example.onlineshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    TextView displayUsername;
    Button btnLogout;
    String dUsername;
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
        recyclerView.setAdapter(new ItemsAdapter(itemsList,getApplicationContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logout=new Intent(Dashboard.this,Login.class);
                startActivity(logout);
            }
        });
    }
    public void prepareItemsList()
    {
        itemsList.add(new Items("shirt","Rs. 2000",R.drawable.kakashi));
        itemsList.add(new Items("t-shirt","Rs. 1500",R.drawable.tg));
    }
}
