package com.example.getapi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdapterProduct extends ArrayAdapter {
    Activity context;
    int Idlayout;
    ArrayList<productItem> myList;
    public AdapterProduct(Activity context, int Idlayout, ArrayList<productItem> myList) {
        super(context, Idlayout, myList);
        this.context = context;
        this.Idlayout = Idlayout;
        this.myList = myList;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(Idlayout, null);
        productItem item = myList.get(position);
        TextView textTen = convertView.findViewById(R.id.textTen);
        TextView textGia = convertView.findViewById(R.id.textGia);
        TextView textSoLuong = convertView.findViewById(R.id.textSoLuong);
        TextView textTongTien = convertView.findViewById(R.id.textTongTien);
        TextView textGiamGia = convertView.findViewById(R.id.textGiamGia);
        TextView textTienTra = convertView.findViewById(R.id.textTienTra);
        ImageView img = convertView.findViewById(R.id.img);

        textTen.setText(item.getTitle());
        textGia.setText(String.valueOf(item.getPrice()) + " $");
        textSoLuong.setText(String.valueOf(item.getQuantity()));
        textTongTien.setText(String.valueOf(item.getTotal()) + " $");
        textGiamGia.setText(String.valueOf(item.getDiscountPercentage()) + " %");
        textTienTra.setText(String.valueOf(item.getDiscountedPrice()) + " $");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            try {
                URL url = new URL(item.getThumbnail());
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                if (parent.getContext() instanceof Activity)
                    ((Activity) parent.getContext()).runOnUiThread(() -> img.setImageBitmap(bitmap));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return convertView;
    }
}
