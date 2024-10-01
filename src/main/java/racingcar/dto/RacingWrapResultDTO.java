package racingcar.dto;

public final class RacingWrapResultDTO {
    final int wrapNumber;
    public final RacingCarStatesDTO carStates;

    public RacingWrapResultDTO(int wrapNumber, RacingCarStatesDTO catStates) {
        this.wrapNumber = wrapNumber;
        this.carStates = catStates;
    }
}
