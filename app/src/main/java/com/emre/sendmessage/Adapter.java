package com.emre.sendmessage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<Model> list;
    Context context;
    Activity activity;

    public Adapter(List<Model> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.mesajlayout, viewGroup, false);

        EditText mesaj = view.findViewById(R.id.message);
        TextView isim = view.findViewById(R.id.Name);
        TextView telNo = view.findViewById(R.id.telNo);
        Button sendMessage = view.findViewById(R.id.send);

        isim.setText(list.get(i).getName());
        telNo.setText(list.get(i).getTelNo());

        String telno = list.get(i).getTelNo();

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mesajIcerik = mesaj.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telno));
                intent.putExtra("sms_body", mesajIcerik);
                activity.startActivity(intent);
            }
        });
        return view;
    }
}
