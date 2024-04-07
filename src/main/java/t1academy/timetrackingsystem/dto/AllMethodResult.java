package t1academy.timetrackingsystem.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder
public class AllMethodResult {

    List<String> methods;

}