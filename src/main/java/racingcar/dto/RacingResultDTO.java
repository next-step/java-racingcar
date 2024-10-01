package racingcar.dto;

public final class RacingResultDTO {
    final RacingWrapResultDTO[] wrapResults;

    public RacingResultDTO(RacingWrapResultDTO[] wrapResults) {
        this.wrapResults = wrapResults;
    }
}
