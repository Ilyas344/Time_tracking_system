package t1academy.timetrackingsystem.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import t1academy.timetrackingsystem.service.TimeTrackingService;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {

    private final TimeTrackingService timeTrackingService;


    @Around("@annotation(t1academy.timetrackingsystem.aspect.annotation.TrackTime)")
    public Object trackTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().getName();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        timeTrackingService.addTimeTracking(executionTime, joinPoint);
        log.info("Метод {} выполнился за {} мс", methodName, executionTime);

        return result;

    }

}

