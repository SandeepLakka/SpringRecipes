package io.github.sandeeplakka.scopedbeaninjectionproblem;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SingletonBeanWithContext implements ApplicationContextAware {

    private ApplicationContext context;

    public PrototypeBean getPrototypeBean() {

            return context.getBean(PrototypeBean.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
