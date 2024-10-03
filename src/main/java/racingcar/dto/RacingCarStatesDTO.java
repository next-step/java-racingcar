package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStatesDTO {
    public final RacingCarStateDTO[] catStates;

    private RacingCarStatesDTO(RacingCarStateDTO[] carStates) {
        this.catStates = carStates;
    }

    public static RacingCarStatesDTO fromRacingCars(RacingCar[] racingCars){
        int racingCarsNum = racingCars.length;
        RacingCarStateDTO[] carStates = new RacingCarStateDTO[racingCarsNum];
        for (int i = 0; i < racingCarsNum; i++) {
            carStates[i] = new RacingCarStateDTO(racingCars[i]);
        }
        return new RacingCarStatesDTO(carStates);
    }
}
