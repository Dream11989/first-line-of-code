package com.example.fragementbestpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.locks.Condition;

public class NewsContentActivity extends AppCompatActivity {
    public   static  void actionStart(Context context,  String newsTitle,String newContent){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newContentFrage = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.new_content_fragment);
        newContentFrage.refresh(newsTitle,newsContent);

    }
}