package t1academy.timetrackingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class AllTimeTrackingResult {
    @Schema(description = "Список", example = "TimeTrackingService")
    List<TimeTrackingResult> timeTrackingResults;
}
