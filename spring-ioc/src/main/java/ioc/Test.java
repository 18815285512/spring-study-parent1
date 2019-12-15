package ioc;

import ioc.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
       // ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("ioc");

        IndexService indexService = (IndexService) applicationContext.getBean("indexService");
        System.out.println(indexService.hashCode());
        indexService.query();
        IndexService indexService1 = (IndexService) applicationContext.getBean("indexService");
        System.out.println(indexService1.hashCode());
        indexService1.query();


    }
}
