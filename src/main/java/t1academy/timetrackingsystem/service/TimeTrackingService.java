package t1academy.timetrackingsystem.service;

import org.aspectj.lang.ProceedingJoinPoint;
import t1academy.timetrackingsystem.dto.AllMethodResult;
import t1academy.timetrackingsystem.dto.AllTimeTrackingResult;
import t1academy.timetrackingsystem.dto.TimeTrackingResult;
import t1academy.timetrackingsystem.model.Method;

import java.util.Optional;

public interface TimeTrackingService {
    /**
     * Записывает время выполнения метода для целей отслеживания времени.
     * @param executionTime Время выполнения метода в миллисекундах.
     * @param joinPoint     {@link ProceedingJoinPoint}, представляющий выполненный метод.
     * @throws RuntimeException В случае ошибки при сохранении данных отслеживания времени.
     */
    void addTimeTracking(long executionTime, ProceedingJoinPoint joinPoint);

    /**
     Находит или создает метод с указанными именем класса и именем метода.
     @param className Имя класса, к которому принадлежит метод.
     @param methodName Имя метода, который необходимо найти или создать.
     @return Объект Method, представляющий найденный или созданный метод.
     */
    Method findOrCreateMethod(String className, String methodName);

    /**
     * Сохраняет данные отслеживания времени для заданного метода в хранилище.
     * @param method Метод, для которого необходимо сохранить данные отслеживания времени.
     */
    void saveTimeTracking(Method method);

    /**
     * Обновляет данные отслеживания времени для заданного метода в хранилище.
     * @param method Метод, для которого необходимо обновить данные отслеживания времени.
     */
    void updateTimeTracking(Method method);

    /**
     * Возвращает данные отслеживания времени для метода с указанным именем.
     * @param methodName Имя метода, для которого необходимо получить данные отслеживания времени.
     * @return TimeTrackingResult, содержащий данные отслеживания времени для найденного метода.
     */
    TimeTrackingResult getTimeTracking(String methodName);

    /**
     * Ищет метод с указанными именем класса и именем метода.
     * @param className Имя класса, к которому принадлежит метод.
     * @param methodName Имя метода, который необходимо найти.
     * @return Optional<Method>, содержащий метод, если он найден, или пустой Optional, если метод не найден.
     */
    Optional<Method> getMethod(String className, String methodName);

    /**
     * Возвращает все последние измерения времени выполнения для всех методов.
     * @return AllTimeTrackingResult, содержащий список TimeTrackingResult для всех методов с их последними измерениями.
     */
    AllTimeTrackingResult getLastMeasurements();

    /**
     * Возвращает список имен всех методов, хранящихся в хранилище.
     * @return AllMethodResult, содержащий список имен всех методов.
     */
    AllMethodResult getAllMethods();
}
