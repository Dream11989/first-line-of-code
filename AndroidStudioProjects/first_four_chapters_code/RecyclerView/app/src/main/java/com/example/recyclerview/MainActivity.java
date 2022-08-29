package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.entity.fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();;
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private  void initFruits(){
        for (int i = 0; i < 4; i++) {
            fruit apple=new fruit("apple",R.drawable.amg1);
            fruitList.add(apple);
            fruit banana=new fruit("banana",R.drawable.back);
            fruitList.add(banana);
            fruit orange=new fruit("orange",R.drawable.next);
            fruitList.add(orange);
            fruit pear=new fruit("pear",R.drawable.edit);
            fruitList.add(pear);

        }
    }
}