package io.github.sandeeplakka.scopedbeaninjectionproblem;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.function.Supplier;

@SpringBootApplication
@Slf4j
public class ScopedBeanInjectionProblemApplication implements CommandLineRunner{

    @Bean
    public SingletonBean returnSingleTonBean(){
        return new SingletonBean();
    }

    @Bean
    public SingletonBeanWithContext returnSingletonBeanWithContext(){
        return new SingletonBeanWithContext();
    }

    @Bean
    public SingletonProviderBean returnSingletonProviderBean(){
        return new SingletonProviderBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean returnPrototypeBean(){
        return new PrototypeBean();
    }

    @Bean
    public SingletonObjectFactoryBean getSingletonObjectFactoryBean(){
        return new SingletonObjectFactoryBean();
    }

    @Bean
    public Supplier<PrototypeBean> prototypeBeanFactory(){
        return PrototypeBean::new;
    }

    @Bean
    public SingletonFunctionBean getSingletonFunctionBean(){
        return new SingletonFunctionBean();
    }

//    @Bean
///*    @Scope(
//            value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//            proxyMode = ScopedProxyMode.TARGET_CLASS)*/
//    public SingletonBeanV1 getSingletonBeanV1(){
//        return new SingletonBeanV1();
//    }
//    @Bean
//    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public PrototypeBeanV1 getPrototypeBeanV1(){
//        return new PrototypeBeanV1();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ScopedBeanInjectionProblemApplication.class, args);
    }

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) {
        initialScenario();
        log.info("------------Application context Injection way---------------------------");
        applicationContextInjectionWay();
        log.info("------------Method Injection way---------------------------");
        methodInjectionWay();
        log.info("------------JEE Inject way---------------------------");
        injectAnnotationWay();
        log.info("------------ObjectFactory way---------------------------");
        objectFactoryWay();
        log.info("------------Java8Way---------------------------");
        Java8Way();
        log.info("---------------------------------------");
    }



    private void initialScenario() {
        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);

    }

    private void printIt(PrototypeBean firstPrototype, PrototypeBean secondPrototype) {
        log.info("Are same v1? : {}", firstPrototype == secondPrototype);
        log.info("Are same v2? : {}", firstPrototype.equals(secondPrototype));
        log.info("<> : {} & {}", firstPrototype.getValue(), secondPrototype.getValue());
    }

    /*
     * Injecting application context and then handing out new bean on getter method of prototype dependency
     * Disadvantages: Violates IOC principle and also has tight coupling with Spring framework.
     */
    private void applicationContextInjectionWay(){
        SingletonBeanWithContext firstSingleton = context.getBean(SingletonBeanWithContext.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonBeanWithContext secondSingleton = context.getBean(SingletonBeanWithContext.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);

    }

    /*
     * @Lookup is runtime injection of bean by spring with getBeans through proxy
     * Spring creates required bean and returns to the caller
     *
     */
    private void methodInjectionWay(){
        SingletonLookupBean firstSingleton = context.getBean(SingletonLookupBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonLookupBean secondSingleton = context.getBean(SingletonLookupBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);

    }

    /*
     * JEE way of handling things
     */
    private void injectAnnotationWay(){
        SingletonProviderBean firstSingleton = context.getBean(SingletonProviderBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonProviderBean secondSingleton = context.getBean(SingletonProviderBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);

    }


    /*
     * Spring's analogous of JEE Provider way
     */
    private void objectFactoryWay(){
        SingletonObjectFactoryBean firstSingleton = context.getBean(SingletonObjectFactoryBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonObjectFactoryBean secondSingleton = context.getBean(SingletonObjectFactoryBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);
    }

    /*
     * Java 8 Function's way
     */
    public void Java8Way(){
        SingletonFunctionBean firstSingleton = context.getBean(SingletonFunctionBean.class);
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();

        // get singleton bean instance one more time
        SingletonFunctionBean secondSingleton = context.getBean(SingletonFunctionBean.class);
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();

        printIt(firstPrototype, secondPrototype);
    }

}
