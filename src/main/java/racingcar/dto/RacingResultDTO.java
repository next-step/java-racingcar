package racingcar.dto;

public final class RacingResultDTO {
    public final RacingWrapResultDTO[] wrapResults;

    private RacingResultDTO(RacingWrapResultDTO[] wrapResults) {
        this.wrapResults = wrapResults;
    }

    public static RacingResultDTO create(RacingWrapResultDTO[] wrapResults) {
        return new RacingResultDTO(wrapResults);
    }
}
