package com.example.fragementbestpractice;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.INotificationSideChannel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment  extends Fragment {
    private Boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newTitleRecyclerView = view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newTitleRecyclerView.setAdapter(adapter);
        return  view;
    }
    private  List<News>getNews(){
        List<News>newsList=new ArrayList<>();
        for (int i = 0; i <=50; i++) {
            News news = new News();
            news.setTitle("this is new title"+i);
            news.setContent(getRandomLength("this is news content"+i+"."));
            newsList.add(news);
        }
        return  newsList;
    }
    private  String getRandomLength(String content){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int length= random.nextInt(20)+1;
        for (int i = 0; i < length; i++) {
            builder.append(content);
        }
        return  builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.new_content_layout)!=null){
            isTwoPane=true;
        }else {
            isTwoPane=false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News>mNewsList;

        public NewsAdapter(List<News> mNewsList) {
            this.mNewsList = mNewsList;
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;
            public ViewHolder(@NonNull View view) {
                super(view);
                newsTitleText=(TextView) view.findViewById(R.id.news_title);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane){
                        NewsContentFragment newContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newContentFragment.refresh(news.getTitle(),news.getContent());
                    }else {
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());

        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

    }
}
