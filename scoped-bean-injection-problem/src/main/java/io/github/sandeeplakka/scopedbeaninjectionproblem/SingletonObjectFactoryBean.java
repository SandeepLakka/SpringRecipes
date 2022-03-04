package io.github.sandeeplakka.scopedbeaninjectionproblem;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SingletonObjectFactoryBean {

    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

    public PrototypeBean getPrototypeBean(){
        return prototypeBeanObjectFactory.getObject();
    }
}
