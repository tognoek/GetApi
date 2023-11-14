package com.example.getapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterCart extends ArrayAdapter {
    Activity context;
    int Idlayout;
    ArrayList<products> myList;
    public AdapterCart(Activity context, int Idlayout, ArrayList<products> myList) {
        super(context, Idlayout, myList);
        this.context = context;
        this.Idlayout = Idlayout;
        this.myList = myList;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup
            parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(Idlayout,null);
        products item = myList.get(position);
        TextView textStt = convertView.findViewById(R.id.textStt);
        TextView textTongTien = convertView.findViewById(R.id.textTongTien);
        TextView textTienTra = convertView.findViewById(R.id.textTienTra);
        TextView textSoLuongPro = convertView.findViewById(R.id.textSoLuongPro);
        TextView textSOLuong = convertView.findViewById(R.id.textSoLuong);
        textStt.setText(item.getId());
        textTongTien.setText(String.valueOf(item.getTotal()) + " $");
        textTienTra.setText(String.valueOf(item.getDiscountedTotal()) + " $");
        textSoLuongPro.setText(String.valueOf(item.getTotalProducts()));
        textSOLuong.setText(String.valueOf(item.getTotalQuantity()));
        return convertView;
    }
}
