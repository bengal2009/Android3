package com.example.lin.android3;

/**
 * Created by blin on 2015/1/30.
 */
public  class NewsItem {
    private String Title;
    private String Address;
    public String getTitle(){
        return Title;
    }
    public String getAddress(){
        return Address;
    }

    public void setTitle(String title  )
    {
        this.Title=title;
    }
    public void setAddress(String address)
    {
        this.Address=address;
    }
    @Override
    public String toString(){
        return Title+":"+Address;
    }
}