package racingcar.dto;

import java.util.List;

public final class RacingResultDTO {
    private final RacingWinnersDTO winners;
    private final RacingWrapResultsDTO wrapResults;

    private RacingResultDTO(RacingWinnersDTO winners, RacingWrapResultsDTO wrapResults) {
        this.winners = winners;
        this.wrapResults = wrapResults;
    }

    public static RacingResultDTO valueOf(List<String> winners, List<RacingWrapResultDTO> wrapResults) {
        return new RacingResultDTO(RacingWinnersDTO.valueOf(winners), RacingWrapResultsDTO.valueOf(wrapResults));
    }

    public RacingWinnersDTO getWinners() {
        return this.winners;
    }

    public RacingWrapResultsDTO getWrapResults() {
        return this.wrapResults;
    }
}
