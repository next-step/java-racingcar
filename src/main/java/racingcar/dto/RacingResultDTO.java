package racingcar.dto;

public final class RacingResultDTO {
    public final RacingWrapResultDTO[] wrapResults;

    public RacingResultDTO(RacingWrapResultDTO[] wrapResults) {
        this.wrapResults = wrapResults;
    }
}
