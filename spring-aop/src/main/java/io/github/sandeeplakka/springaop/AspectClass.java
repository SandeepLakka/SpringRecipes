package io.github.sandeeplakka.springaop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
class AspectClass {

    @Before("execution(* io.github.sandeeplakka.springaop..*(..))")
    public void logMethods(JoinPoint jp) {
        log.info("executed {}", jp.getSignature().toString());
        //log.info("execution of "+joinpoint.ge);
    }
}
