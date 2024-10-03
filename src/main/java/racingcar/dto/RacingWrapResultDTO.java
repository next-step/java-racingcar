package racingcar.dto;

public final class RacingWrapResultDTO {
    public final int wrapNumber;
    public final RacingCarStatesDTO carStates;

    private RacingWrapResultDTO(int wrapNumber, RacingCarStatesDTO catStates) {
        this.wrapNumber = wrapNumber;
        this.carStates = catStates;
    }

    public static RacingWrapResultDTO create(int wrapNumber, RacingCarStatesDTO catStates) {
        return new RacingWrapResultDTO(wrapNumber, catStates);
    }
}
