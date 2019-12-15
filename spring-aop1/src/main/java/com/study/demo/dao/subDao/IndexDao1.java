package com.study.demo.dao.subDao;

import com.study.demo.annotation.PengChen;
import com.study.demo.dao.subDao.Dao1;
import org.springframework.stereotype.Repository;

@PengChen
@Repository
public class IndexDao1 implements Dao1 {

    @Override
    public void query() {
        System.out.println("indexDao1");
    }

    public String query(String str) {
        System.out.println("query1");
        return str;
    }

    public String query(String str,Integer i) {
        System.out.println("query2");
        return str;
    }
}
