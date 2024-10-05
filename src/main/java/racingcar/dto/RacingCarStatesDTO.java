package racingcar.dto;

import racingcar.RacingCar;

public final class RacingCarStatesDTO {
    public final RacingCarStateDTO[] carStates;

    private RacingCarStatesDTO(RacingCarStateDTO[] carStates) {
        this.carStates = carStates;
    }

    public static RacingCarStatesDTO fromRacingCars(RacingCar[] racingCars) {
        int racingCarsNum = racingCars.length;
        RacingCarStateDTO[] carStates = new RacingCarStateDTO[racingCarsNum];
        for (int i = 0; i < racingCarsNum; i++) {
            carStates[i] = RacingCarStateDTO.fromRacingCar(racingCars[i]);
        }
        return new RacingCarStatesDTO(carStates);
    }
}
