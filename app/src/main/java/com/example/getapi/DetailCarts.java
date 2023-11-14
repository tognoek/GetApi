package com.example.getapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailCarts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_carts);
        Intent intent = getIntent();
        ListView lv = findViewById(R.id.lv_pro);
        ArrayList<productItem> productItemArrayList = (ArrayList<productItem>) intent.getSerializableExtra("arrayProduct");
        if (productItemArrayList != null){
            AdapterProduct adapterProduct = new AdapterProduct(this, R.layout.item_product, productItemArrayList);
            lv.setAdapter(adapterProduct);
        }
        findViewById(R.id.back).setOnClickListener(view ->
                getOnBackPressedDispatcher().onBackPressed());
    }
}