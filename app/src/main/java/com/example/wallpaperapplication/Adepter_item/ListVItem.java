package com.example.wallpaperapplication.Adepter_item;

public class ListVItem {

    public String id,path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ListVItem(String id, String path) {
        this.id = id;
        this.path = path;
    }
}
