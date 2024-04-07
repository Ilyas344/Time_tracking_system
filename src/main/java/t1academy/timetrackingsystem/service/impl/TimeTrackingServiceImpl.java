package t1academy.timetrackingsystem.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;
import t1academy.timetrackingsystem.dto.AllMethodResult;
import t1academy.timetrackingsystem.dto.AllTimeTrackingResult;
import t1academy.timetrackingsystem.dto.TimeTrackingResult;
import t1academy.timetrackingsystem.mapper.MethodMapper;
import t1academy.timetrackingsystem.model.Measurement;
import t1academy.timetrackingsystem.model.Method;
import t1academy.timetrackingsystem.reposytory.MethodRepository;
import t1academy.timetrackingsystem.service.TimeTrackingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeTrackingServiceImpl implements TimeTrackingService {
    private final MethodRepository methodRepository;
    private final MethodMapper methodMapper;

    @Override
    public void addTimeTracking(long executionTime, ProceedingJoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        Method method = findOrCreateMethod(className, methodName);
        method.getMeasurements().add(new Measurement(executionTime, method));

        saveTimeTracking(method);
    }

    private Method findOrCreateMethod(String className, String methodName) {
        Optional<Method> existingMethod = getMethod(className, methodName);
        if (existingMethod.isPresent()) {
            return existingMethod.get();
        }
        Method newMethod = new Method(className, methodName);
        saveTimeTracking(newMethod);
        return newMethod;
    }


    @Override
    public void saveTimeTracking(Method method) {
        methodRepository.save(method);

    }

    @Override
    public Optional<Method> getMethod(String className, String methodName) {
        return methodRepository.findByClassNameAndMethodName(className, methodName);
    }


    @Override
    public void updateTimeTracking(Method method) {
        methodRepository.save(method);
    }

    @Override
    public TimeTrackingResult getTimeTracking(String methodName) {
        return methodMapper.toDto(methodRepository.findMethodByMethodName(methodName));
    }


    @Override
    public AllTimeTrackingResult getLastMeasurements() {
        List<Method> methods = methodRepository.findMethods();
        List<TimeTrackingResult> response = methods.stream().map(methodMapper::toDto).collect(Collectors.toList());
        return AllTimeTrackingResult.builder()
                .timeTrackingResults(response)
                .build();
    }


    @Override
    public AllMethodResult getAllMethods() {
        return AllMethodResult.builder()
                .methods(methodRepository.findAllMethodNames())
                .build();

    }


}
