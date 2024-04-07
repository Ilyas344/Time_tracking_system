package t1academy.timetrackingsystem.service;

import org.aspectj.lang.ProceedingJoinPoint;
import t1academy.timetrackingsystem.dto.AllMethodResult;
import t1academy.timetrackingsystem.dto.AllTimeTrackingResult;
import t1academy.timetrackingsystem.dto.TimeTrackingResult;
import t1academy.timetrackingsystem.model.Method;

import java.util.Optional;

public interface TimeTrackingService {
    void addTimeTracking(long executionTime, ProceedingJoinPoint joinPoint);

    void saveTimeTracking(Method method);

    void updateTimeTracking(Method method);

    TimeTrackingResult getTimeTracking(String methodName);

    Optional<Method> getMethod(String className, String methodName);

    AllTimeTrackingResult getLastMeasurements();

    AllMethodResult getAllMethods();
}
