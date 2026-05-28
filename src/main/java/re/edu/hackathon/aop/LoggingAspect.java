package re.edu.hackathon.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* re.edu.hackathon.service.WatchServiceImpl.create(..))")
    public void logMethodCreate(JoinPoint joinPoint){
        log.info("Method duoc goi: {}" , joinPoint.getSignature().getName());
    }

    @Before("execution(* re.edu.hackathon.service.WatchServiceImpl.update(..))")
    public void logMethodUpdate(JoinPoint joinPoint){
        log.info("Method duoc goi: {}" , joinPoint.getSignature().getName());
    }

    @Before("execution(* re.edu.hackathon.service.WatchServiceImpl.patch(..))")
    public void logMethodPatch(JoinPoint joinPoint){
        log.info("Method duoc goi: {}" , joinPoint.getSignature().getName());
    }
}
