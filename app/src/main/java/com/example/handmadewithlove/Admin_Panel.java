package com.example.handmadewithlove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Admin_Panel extends AppCompatActivity {
    private ImageView necklace, earings, bangles, jewellerySet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__panel);

        necklace = (ImageView) findViewById(R.id.t_necklace);
        earings = (ImageView) findViewById(R.id.t_earings);
        bangles = (ImageView) findViewById(R.id.t_bangles);
        jewellerySet = (ImageView) findViewById(R.id.t_jewellery_set);

        necklace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Panel.this, AdminAddNewProduct.class);
                intent.putExtra("category", "necklace");
                startActivity(intent);
            }
        });

        earings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Panel.this, AdminAddNewProduct.class);
                intent.putExtra("category", "earings");
                startActivity(intent);
            }
        });

        bangles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Panel.this, AdminAddNewProduct.class);
                intent.putExtra("category", "bangles");
                startActivity(intent);
            }
        });

        jewellerySet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Panel.this, AdminAddNewProduct.class);
                intent.putExtra("category", "jewellerySet");
                startActivity(intent);
            }
        });
    }
}
