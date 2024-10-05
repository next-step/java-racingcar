package racingcar.logic;

import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;
import racingcar.logic.movableStrategy.RandomMovableStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarSimulator {
    public static RacingResultDTO simulate(List<String> carNames, int tryNumber) {
        List<RacingCar> racingCars = createRacingCars(carNumber);
        return simulateRacing(tryNumber, racingCars);
    }

    private static RacingResultDTO simulateRacing(int tryNumber, List<RacingCar> racingCars) {
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            wrapResults.add(simulateWrap(i, racingCars));
        }
        return RacingResultDTO.valueOf(wrapResults);
    }

    private static RacingWrapResultDTO simulateWrap(int wrapNo, List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.race(new RandomMovableStrategy());
        }
        RacingCarStatesDTO carStates = RacingCarStatesDTO.valueOf(racingCars);
        return RacingWrapResultDTO.valueOf(wrapNo, carStates);
    }

    private static List<RacingCar> createRacingCars(int carNumber) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            racingCars.add(RacingCar.createWithCarNo(i));
        }
        return racingCars;
    }
}
