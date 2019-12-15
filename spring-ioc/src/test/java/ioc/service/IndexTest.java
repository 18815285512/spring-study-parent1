package ioc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class IndexTest {

   // private IndexService indexService;
    @Test
    public void test(){
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classPath:spring.xml");
        IndexService indexService = (IndexService) applicationContext.getBean("indexService");
        indexService.query();
    }
}