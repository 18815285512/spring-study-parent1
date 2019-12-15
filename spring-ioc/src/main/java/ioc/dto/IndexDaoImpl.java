package ioc.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository("dao")
public class IndexDaoImpl implements IndexDao{
    @Override
    public void query() {
        System.out.println("IndexDaoImp0");
    }
}
