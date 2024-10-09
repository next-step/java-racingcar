package racingcar.dto;

import racingcar.domain.CarRacing;

public final class RacingResultDTO {
    private final RacingWinnerNamesDTO winners;
    private final RacingWrapResultsDTO wrapResults;

    private RacingResultDTO(RacingWinnerNamesDTO winners, RacingWrapResultsDTO wrapResults) {
        this.winners = winners;
        this.wrapResults = wrapResults;
    }

    public static RacingResultDTO valueOf(CarRacing carRacing) {
        return new RacingResultDTO(RacingWinnerNamesDTO.valueOf(carRacing.findWinners()), carRacing.getWrapResults());
    }

    public RacingWinnerNamesDTO getWinners() {
        return this.winners;
    }

    public RacingWrapResultsDTO getWrapResults() {
        return this.wrapResults;
    }
}
