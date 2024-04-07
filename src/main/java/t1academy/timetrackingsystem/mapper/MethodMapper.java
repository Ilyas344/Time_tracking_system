package t1academy.timetrackingsystem.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import t1academy.timetrackingsystem.dto.TimeTrackingResult;
import t1academy.timetrackingsystem.model.Method;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MethodMapper {
    @Mapping(target = "className", source = "className")
    @Mapping(target = "methodName", source = "methodName")
    @Mapping(target = "lastTime", source = "measurements", qualifiedByName = "getLastTime")
    @Mapping(target = "totalTime", source = "measurements", qualifiedByName = "getTotalTime")
    @Mapping(target = "averageTime", source = "measurements", qualifiedByName = "getAverageTime")
    TimeTrackingResult toDto(Method methods);

    @Named("getLastTime")
    default long getLastTime(List<Long> measurements) {
        return measurements.get(measurements.size() - 1);
    }

    @Named("getTotalTime")
    default long getTotalTime(List<Long> measurements) {
        return measurements.stream().reduce(0L, Long::sum);
    }

    @Named("getAverageTime")
    default double getAverageTime(List<Long> measurements) {
        return measurements.stream().mapToDouble(Long::doubleValue).average().orElse(0);
    }


}
