package com.example.uicustomviews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uicustomviews.entity.fruit;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<fruit> mFruitList;

    static class ViewHolder extends  RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(@NonNull View view) {
            super(view);
            fruitView=view;
            fruitImage=(ImageView) view.findViewById(R.id.fruit_image);
            fruitName=(TextView) view.findViewById(R.id.fruit_name);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.friut_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon=holder.getAbsoluteAdapterPosition();
                fruit fruit = mFruitList.get(positon);
                Toast.makeText(v.getContext(), "you click name    " + fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon=holder.getAbsoluteAdapterPosition();
                fruit fruit = mFruitList.get(positon);
                Toast.makeText(v.getContext(), "you click image   " + fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageid());
        holder.fruitName.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


    public FruitAdapter(List<fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }
}

