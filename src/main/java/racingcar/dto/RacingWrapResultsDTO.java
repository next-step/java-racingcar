package racingcar.dto;

import racingcar.domain.RacingHistories;
import racingcar.domain.RacingHistory;

import java.util.ArrayList;
import java.util.List;

public final class RacingWrapResultsDTO {
    private final List<RacingWrapResultDTO> wrapResults;

    private RacingWrapResultsDTO(List<RacingWrapResultDTO> wrapResults) {
        this.wrapResults = wrapResults;
    }

    public static RacingWrapResultsDTO valueOf(List<RacingWrapResultDTO> wrapResults) {
        return new RacingWrapResultsDTO(wrapResults);
    }

    public static RacingWrapResultsDTO valueOf(RacingHistories histories) {
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        for(RacingHistory history : histories.value()){
            wrapResults.add(RacingWrapResultDTO.valueOf(history));
        }
        return new RacingWrapResultsDTO(wrapResults);
    }

    public List<RacingWrapResultDTO> getWrapResults() {
        return this.wrapResults;
    }
}
