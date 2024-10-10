package racingcar.dto;

import java.util.List;

public final class RacingWrapResultsDTO {
    private final List<RacingWrapResultDTO> wrapResults;

    private RacingWrapResultsDTO(List<RacingWrapResultDTO> wrapResults) {
        this.wrapResults = wrapResults;
    }

    public static RacingWrapResultsDTO valueOf(List<RacingWrapResultDTO> wrapResults) {
        return new RacingWrapResultsDTO(wrapResults);
    }

    public List<RacingWrapResultDTO> getWrapResults() {
        return this.wrapResults;
    }
}
