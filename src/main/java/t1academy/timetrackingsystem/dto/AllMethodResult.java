package t1academy.timetrackingsystem.dto;

import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class AllMethodResult {

    String className;
    String methodName;
    String group;
    
}