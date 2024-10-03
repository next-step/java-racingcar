package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStatesDTO {
    public final RacingCarStateDTO[] catStates;

    public RacingCarStatesDTO(RacingCar[] racingCars) {
        int racingCarsNum = racingCars.length;
        RacingCarStateDTO[] carStates = new RacingCarStateDTO[racingCarsNum];
        for (int i = 0; i < racingCarsNum; i++) {
            carStates[i] = new RacingCarStateDTO(racingCars[i]);
        }
        this.catStates = carStates;
    }
}
