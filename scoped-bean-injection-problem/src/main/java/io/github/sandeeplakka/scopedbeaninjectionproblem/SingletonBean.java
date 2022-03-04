package io.github.sandeeplakka.scopedbeaninjectionproblem;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;

@Slf4j
public class SingletonBean {

    @Autowired
    private PrototypeBean prototypeBean;

    public SingletonBean(){
        log.info("Singleton bean instantiated");
    }

    public PrototypeBean getPrototypeBean(){
        log.info(String.valueOf(LocalTime.now()));
        return this.prototypeBean;
    }
}
