package com.study.demo.Test;

import com.study.demo.config.AppConfig;
import com.study.demo.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao dao = (IndexDao) applicationContext.getBean("indexDemo");
        dao.query();
    }
}
