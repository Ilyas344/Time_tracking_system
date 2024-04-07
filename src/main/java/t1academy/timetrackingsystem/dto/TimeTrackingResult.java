package t1academy.timetrackingsystem.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class TimeTrackingAverageResult {
    @NotNull
    String className;
    @NotNull
    String methodName;
    @NotNull
    String group;
    @Positive
    double averageTime;

}
