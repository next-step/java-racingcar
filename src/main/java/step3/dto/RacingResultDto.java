package step3.dto;

import java.util.List;

public class RacingResultDto {

    private List<List<CarStatusDto>> attempts;

    public RacingResultDto(List<List<CarStatusDto>> attempts) {
        this.attempts = attempts;
    }

    public List<List<CarStatusDto>> getAttempts() {
        return attempts;
    }
}
