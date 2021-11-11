package com.emre.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Model> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeOlustur();
        tanimla();
    }

    public void listeOlustur() {

        list = new ArrayList<Model>();
        Model m1 = new Model("Emre Deniz", "5318264821");
        Model m2 = new Model("Metin Deniz", "05324306309");
        Model m3 = new Model("Baise Deniz", "5382207825");

        list.add(m1);
        list.add(m2);
        list.add(m3);
    }

    public void tanimla() {
        listView = findViewById(R.id.messageList);
        Adapter adapter = new Adapter(list, this, this);
        listView.setAdapter(adapter);


    }
}