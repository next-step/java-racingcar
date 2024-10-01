package racingcar.dto;

public class RacingWrapResultDTO {
    final int wrapNumber;
    final RacingCarStatesDTO catStates;

    public RacingWrapResultDTO(int wrapNumber, RacingCarStatesDTO catStates) {
        this.wrapNumber = wrapNumber;
        this.catStates = catStates;
    }
}
