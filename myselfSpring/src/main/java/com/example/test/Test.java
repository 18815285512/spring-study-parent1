package com.example.test;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        beanFactory.getBean("userService");
    }
}
