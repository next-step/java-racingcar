package racingcar.dto;

import java.util.List;

public final class RacingResultDTO {
    private final List<RacingWrapResultDTO> wrapResults;

    private RacingResultDTO(List<RacingWrapResultDTO> wrapResults) {
        this.wrapResults = wrapResults;
    }

    public static RacingResultDTO create(List<RacingWrapResultDTO> wrapResults) {
        return new RacingResultDTO(wrapResults);
    }

    public List<RacingWrapResultDTO> getWrapResults() {
        return this.wrapResults;
    }
}
