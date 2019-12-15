package com.study.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDao implements Dao {
    @Override
    public void query() {
        System.out.println("indexDao");
    }
}
