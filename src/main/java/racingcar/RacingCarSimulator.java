package racingcar;

import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;

public class RacingCarSimulator {
    public static RacingResultDTO simulate(int carNumber, int tryNumber) {
        RacingCar[] racingCars = createRacingCars(carNumber);
        return simulateRacing(tryNumber, racingCars);
    }

    private static RacingResultDTO simulateRacing(int tryNumber, RacingCar[] racingCars) {
        RacingWrapResultDTO[] wrapResults = new RacingWrapResultDTO[tryNumber];
        for (int i = 0; i < tryNumber; i++) {
            wrapResults[i] = simulateWrap(i, racingCars);
        }
        return new RacingResultDTO(wrapResults);
    }

    private static RacingWrapResultDTO simulateWrap(int wrapNo, RacingCar[] racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
        }
        RacingCarStatesDTO carStates = RacingCarStatesDTO.fromRacingCars(racingCars);
        return new RacingWrapResultDTO(wrapNo, carStates);
    }

    private static RacingCar[] createRacingCars(int carNumber) {
        RacingCar[] racingCars = new RacingCar[carNumber];
        for (int i = 0; i < carNumber; i++) {
            racingCars[i] = new RacingCar(i);
        }
        return racingCars;
    }
}
