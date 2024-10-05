package racingcar.logic;

import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;
import racingcar.logic.movableStrategy.RandomMovableStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCarSimulator {
    public static RacingResultDTO simulate(List<String> carNames, int tryNumber) {
        List<RacingCar> racingCars = createRacingCars(carNames);
        return simulateRacing(tryNumber, racingCars);
    }

    private static RacingResultDTO simulateRacing(int tryNumber, List<RacingCar> racingCars) {
        List<RacingWrapResultDTO> wrapResults = proceedWraps(tryNumber, racingCars);
        List<String> winners = findWinners(racingCars);
        return RacingResultDTO.valueOf(winners, wrapResults);
    }

    private static List<RacingWrapResultDTO> proceedWraps(int tryNumber, List<RacingCar> racingCars) {
        List<RacingWrapResultDTO> wrapResults = initializeWrapResults(racingCars);
        for (int i = 0; i < tryNumber; i++) {
            wrapResults.add(simulateWrap(i + 1, racingCars));
        }
        return wrapResults;
    }

    private static List<RacingWrapResultDTO> initializeWrapResults(List<RacingCar> racingCars) {
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        wrapResults.add(RacingWrapResultDTO.valueOf(0, RacingCarStatesDTO.valueOf(racingCars)));
        return wrapResults;
    }

    private static List<String> findWinners(List<RacingCar> racingCars) {
        int topDistance = findTopDistance(racingCars);
        return findCarsWithTopDistance(racingCars, topDistance);
    }

    private static List<String> findCarsWithTopDistance(List<RacingCar> racingCars, int topDistance) {
        List<String> carsWithTopDistance = new ArrayList<>();
        for (RacingCar car : racingCars) {
            updateCarsWithTopDistance(topDistance, car, carsWithTopDistance);
        }
        return carsWithTopDistance;
    }

    private static void updateCarsWithTopDistance(int topDistance, RacingCar car, List<String> carsWithTopDistance) {
        if (car.getPosition() == topDistance) {
            carsWithTopDistance.add(car.getName());
        }
    }

    private static int findTopDistance(List<RacingCar> racingCars) {
        return Collections.max(racingCars, Comparator.comparingInt(RacingCar::getPosition)).getPosition();
    }

    private static RacingWrapResultDTO simulateWrap(int wrapNo, List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.race(new RandomMovableStrategy());
        }
        RacingCarStatesDTO carStates = RacingCarStatesDTO.valueOf(racingCars);
        return RacingWrapResultDTO.valueOf(wrapNo, carStates);
    }

    private static List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int carNumber = 0; carNumber < carNames.size(); carNumber++) {
            racingCars.add(RacingCar.valueOf(carNames.get(carNumber), carNumber));
        }
        return racingCars;
    }
}
