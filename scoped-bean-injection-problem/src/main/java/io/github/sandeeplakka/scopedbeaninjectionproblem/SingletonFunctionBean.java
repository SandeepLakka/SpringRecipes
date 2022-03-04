package io.github.sandeeplakka.scopedbeaninjectionproblem;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;


public class SingletonFunctionBean {

    @Autowired
    private Supplier<PrototypeBean> prototypeBeanFactory;

    public PrototypeBean getPrototypeBean(){
        return prototypeBeanFactory.get();
    }
}
