package com.example.getapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<products> productsArrayList;
    AdapterCart adapterCart;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productsArrayList = new ArrayList<>();
        lv = findViewById(R.id.lv_cart);
        adapterCart = new AdapterCart(this, R.layout.item_cart, productsArrayList);
        lv.setAdapter(adapterCart);
        new GetApiJson().execute("https://dummyjson.com/carts");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailCarts.class);
                ArrayList<productItem> productItemArrayList = productsArrayList.get(position).getProductItemArrayList();
                intent.putExtra("arrayProduct", productItemArrayList);
                startActivity(intent);
            }
        });
    }

    private class GetApiJson extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return content.toString();
        }
        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray carts = jsonObject.getJSONArray("carts");
                for (int i = 0; i < carts.length(); i++){
                    JSONObject object = carts.getJSONObject(i);
                    String id = object.getString("id");
                    JSONArray products = object.getJSONArray("products");
                    ArrayList<productItem> productItems = new ArrayList<>();
                    for (int t = 0; t < products.length(); t++){
                        JSONObject objectProduct = products.getJSONObject(t);
                        String idPr = objectProduct.getString("id");
                        String titlePr = objectProduct.getString("title");
                        double pricePr = Double.parseDouble(objectProduct.getString("price"));
                        int quantityPr = Integer.parseInt(objectProduct.getString("quantity"));
                        double totalPr = Double.parseDouble(objectProduct.getString("total"));
                        double discountPercentagePr = Double.parseDouble(objectProduct.getString("discountPercentage"));
                        double discountedPricePr = Double.parseDouble(objectProduct.getString("discountedPrice"));
                        String thumbnailPr = objectProduct.getString("thumbnail");
                        productItem productItemObj = new productItem(idPr, titlePr, pricePr, quantityPr, totalPr, discountPercentagePr, discountedPricePr, thumbnailPr);
                        productItems.add(productItemObj);
                    }
                    double total = Double.parseDouble(object.getString("total"));
                    double discountedTotal = Double.parseDouble(object.getString("discountedTotal"));
                    String userId = object.getString("userId");
                    int totalProducts = Integer.parseInt(object.getString("totalProducts"));
                    int totalQuantity = Integer.parseInt(object.getString("totalQuantity"));
                    products productsObj = new products(id, productItems, total, discountedTotal, userId, totalProducts, totalQuantity);
                    productsArrayList.add(productsObj);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            adapterCart.notifyDataSetChanged();

        }
    }
}