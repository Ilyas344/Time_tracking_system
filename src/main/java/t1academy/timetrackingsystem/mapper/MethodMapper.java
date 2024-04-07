package t1academy.timetrackingsystem.mapper;

import org.mapstruct.*;
import t1academy.timetrackingsystem.dto.TimeTrackingResult;
import t1academy.timetrackingsystem.model.Measurement;
import t1academy.timetrackingsystem.model.Method;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MethodMapper {
    @Mapping(target = "className", source = "className")
    @Mapping(target = "methodName", source = "methodName")
    @Mapping(target = "lastTime", source = "measurements", qualifiedByName = "getLastTime")
    @Mapping(target = "totalTime", source = "measurements",  qualifiedByName = "getTotalTime")
    @Mapping(target = "averageTime", source = "measurements",  qualifiedByName = "getAverageTime")
    TimeTrackingResult toDto(Method methods);

    @Named("getLastTime")
    default Long getLastTime(List<Measurement> measurements) {
        return measurements.get(measurements.size() - 1).getExecutionTime();
    }

    @Named("getTotalTime")
    default Long getTotalTime(List<Measurement> measurements) {
        return measurements.stream().mapToLong(Measurement::getExecutionTime).sum();
    }

    @Named("getAverageTime")
    default Double getAverageTime(List<Measurement> measurements) {
        return measurements.stream().mapToDouble(Measurement::getExecutionTime).average().orElse(0.0);
    }



}