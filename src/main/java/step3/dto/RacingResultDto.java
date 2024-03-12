package step3.dto;

import java.util.Collections;
import java.util.List;

public class RacingResultDto {

    private List<List<CarStatusDto>> attempts;
    private List<String> winners;

    public RacingResultDto(List<List<CarStatusDto>> attempts, List<String> winners) {
        this.attempts = attempts;
        this.winners = winners;
    }

    public RacingResultDto(List<List<CarStatusDto>> attempts) {
        this.attempts = attempts;
    }

    public List<List<CarStatusDto>> getAttempts() {
        return attempts;
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }
}
