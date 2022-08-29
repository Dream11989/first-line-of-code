package com.example.uicustomviews.entity;

public class fruit {
    private  String name;
    private  int imageid;

    public fruit(String name, int imageid) {
        this.name = name;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}

