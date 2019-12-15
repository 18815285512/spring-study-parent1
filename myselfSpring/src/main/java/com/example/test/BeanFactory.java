package com.example.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BeanFactory {
    Map<String, Object> beanMap = new HashMap();

    public BeanFactory(String filePath) {
        // 这边仿造XMLClassPathApplicationContext
        File file = new File(getUrl() + filePath);
        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read(file);
            Element root = read.getRootElement();
            for (Iterator<Element> it = root.elementIterator(); it.hasNext(); ) {
                Element element = it.next();
                Attribute id = element.attribute("id");
                String beanName = id.getValue();
                Attribute aClass = element.attribute("class");
                String classValue = aClass.getValue();
                Object o = Class.forName(classValue).newInstance();

                Iterator<Element> childrenElementIt = element.elementIterator();
                while (childrenElementIt.hasNext()) {
                    Element childrenElement = childrenElementIt.next();
                    if ("property".equals(element.getName())){
                        // 通过setter构建
                        Attribute nameAttribute = element.attribute("name");
                        String namePart = nameAttribute.getValue();
                        String methodName="set"+namePart.substring(0,1).toUpperCase()+namePart.substring(1);
                        Method method = o.getClass().getMethod(methodName);
                        Attribute refAttribute = element.attribute("ref");
                        String propertyBeanName = refAttribute.getValue();
                        Object o1 = beanMap.get(propertyBeanName);
                        if (o1!=null){
                            method.invoke(o, o1);
                        }
                    }
                }

                beanMap.put(beanName, o);

            }

        } catch (Exception e) {
            System.out.println("io异常了");
        }
    }

    /**
     * 获取bean
     *
     * @param beanName
     * @return
     * @throws NoSuchFieldException
     */
    public Object getBean(String beanName) throws NoSuchFieldException {
        Object bean = beanMap.get(beanName);
        if (bean == null) {
            throw new NoSuchFieldException("没有这样的bean");
        }
        return bean;
    }

    private String getUrl() {
        URL resource = this.getClass().getResource("/");
        System.out.println(resource);
        return resource.getPath();
    }

}
