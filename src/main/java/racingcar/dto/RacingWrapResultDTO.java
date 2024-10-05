package racingcar.dto;

public final class RacingWrapResultDTO {
    private final int wrapNumber;
    private final RacingCarStatesDTO carStates;

    private RacingWrapResultDTO(int wrapNumber, RacingCarStatesDTO catStates) {
        this.wrapNumber = wrapNumber;
        this.carStates = catStates;
    }

    public static RacingWrapResultDTO valueOf(int wrapNumber, RacingCarStatesDTO catStates) {
        return new RacingWrapResultDTO(wrapNumber, catStates);
    }

    public int getWrapNumber() {
        return this.wrapNumber;
    }

    public RacingCarStatesDTO getCarStates() {
        return this.carStates;
    }
}
