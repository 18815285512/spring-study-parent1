package com.study.demo.dao;

import com.study.demo.annotation.PengChen;
import org.springframework.stereotype.Repository;
@PengChen
@Repository("indexDao")
public class IndexDao implements Dao{
    @Override
    public void query() {
        System.out.println("indexDao");
    }


    @Override
    public String query1(String str) {
        System.out.println("query1");
        return str;
    }
}
