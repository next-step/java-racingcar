package racingcar.dto;

public class RacingResultDTO {
    final RacingWrapResultDTO[] wrapResults;

    public RacingResultDTO(RacingWrapResultDTO[] wrapResults) {
        this.wrapResults = wrapResults;
    }
}
