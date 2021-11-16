package com.chent57.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    private String lable = "1";


    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getLable() {
        return lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
