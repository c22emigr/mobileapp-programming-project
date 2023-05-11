package com.example.project;

import java.util.ArrayList;

public class Bergen {
    private String name;
    private int size;

    public Bergen(String name, int size){
        this.name = name;
        this.size = size;
    }

    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
