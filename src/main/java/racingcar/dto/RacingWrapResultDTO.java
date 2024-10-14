package racingcar.dto;

import racingcar.domain.RacingCarStates;
import racingcar.domain.RacingHistory;

public final class RacingWrapResultDTO {
    private final int wrapNumber;
    private final RacingCarStatesDTO carStates;

    private RacingWrapResultDTO(int wrapNumber, RacingCarStatesDTO catStates) {
        this.wrapNumber = wrapNumber;
        this.carStates = catStates;
    }

    public static RacingWrapResultDTO valueOf(RacingHistory history) {
        RacingCarStatesDTO racingCarStatesDTO = RacingCarStatesDTO.valueOf(history.getCarStates());
        return new RacingWrapResultDTO(history.getWrapNumber(), racingCarStatesDTO);
    }

    public int getWrapNumber() {
        return this.wrapNumber;
    }

    public RacingCarStatesDTO getCarStates() {
        return this.carStates;
    }
}
