package com.example.onlineshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView displayUsername;
    Button btnLogout;
    String dUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        displayUsername=findViewById(R.id.getUsername);
        btnLogout=findViewById(R.id.logout);

        dUsername=getIntent().getStringExtra("USERNAME");
        displayUsername.setText(dUsername);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logout=new Intent(Dashboard.this,Login.class);
                startActivity(logout);
            }
        });
    }
}
