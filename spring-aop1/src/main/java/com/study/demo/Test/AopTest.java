package com.study.demo.Test;

import com.study.demo.config.AppConfig;
import com.study.demo.dao.Dao;
import com.study.demo.dao.subDao.Dao1;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Proxy;

public class AopTest {
    public static void main(String[] args) {
        //ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Dao dao = (Dao) applicationContext.getBean("indexDao");
        System.out.println(dao instanceof Proxy);
     //   dao.query();

        System.out.println("--------------------------------------");
        Dao1 dao1 = (Dao1) applicationContext.getBean("indexDao111");
        //dao1.query();
        String testParameter = dao1.query("testParameter");

        System.out.println("返回值：" + testParameter);
//
//        Class<?>[] interfaces = new Class[]{Dao.class};
//        byte[] indexDaos = ProxyGenerator.generateProxyClass("indexDao", interfaces);
//        File file = new File("d://study//AopTest.class");
//        try {
//            FileOutputStream fw = new FileOutputStream(file);
//            fw.write(indexDaos);
//            fw.flush();
//            fw.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        System.out.println("-------------------------------");
//        dao.query("test");
//        System.out.println("-------------------------------");
//        dao.query("test",1);
    }
}
