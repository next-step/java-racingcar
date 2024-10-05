package racingcar.logic;

import racingcar.dto.RacingCarStatesDTO;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;
import racingcar.logic.movableStrategy.RandomMovableStrategy;

import java.util.ArrayList;
import java.util.List;

import static racingcar.logic.RacingCar.INITIAL_POSITION;

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
        List<RacingWrapResultDTO> wrapResults = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            wrapResults.add(simulateWrap(i, racingCars));
        }
        return wrapResults;
    }

    private static List<String> findWinners(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = INITIAL_POSITION;
        for(RacingCar car: racingCars){
            if(car.getPosition() > maxPosition);{
                winners.add(car.getName());
            }
            if(car.getPosition() == maxPosition) {
                winners = new ArrayList<>();
                winners.add(car.getName());
            }
        }
        return winners;
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
