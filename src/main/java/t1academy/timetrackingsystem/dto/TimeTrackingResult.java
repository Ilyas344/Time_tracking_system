package t1academy.timetrackingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Value;


@Value
@Builder
public class TimeTrackingResult {
    @Schema(description = "Название класса", example = "TimeTrackingService")
    @NotNull
    String className;
    @Schema(description = "Название метода", example = "trackTime")
    @NotNull
    String methodName;
    @Schema(description = "Последнее измерение", example = "0")
    @Positive
    long lastTime;
    @Schema(description = "Общее измерение", example = "0")
    @Positive
    long totalTime;
    @Schema(description = "Среднее измерение", example = "0")
    @Positive
    double averageTime;

}
