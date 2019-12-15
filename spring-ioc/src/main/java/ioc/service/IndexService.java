package ioc.service;

import ioc.dto.IndexDao;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Autowired
    private IndexDao indexDao;

    public void query(){
        System.out.println(indexDao.hashCode());
        indexDao.query();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}
