package racingcar;

import racingcar.entity.RacingCar;
import racingcar.strategy.MoveStrategy;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {
    public RacingCarGame(List<RacingCar> racingCars, String[] carNames){
        initializeRacingCars(racingCars, carNames);
    }
    public void initializeRacingCars(List<RacingCar> racingCars, String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            racingCars.add(new RacingCar(carNames[i]));
        }
    }

    public void race(List<RacingCar> racingCars, int tryNumber, MoveStrategy moveStrategy) {
        ResultView.printResultFirstLine();
        for (int i = 0; i < tryNumber; i++) {
            raceOneStep(racingCars, moveStrategy);
            ResultView.printRacingCarsPosition(racingCars);
        }
    }

    public void raceOneStep(List<RacingCar> racingCars, MoveStrategy moveStrategy) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveIfMovable(moveStrategy);
        }
    }

    public int findMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > maxPosition) {
                maxPosition = racingCar.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> pickWinners(List<RacingCar> racingCars, int winnerRecord) {
        return racingCars.stream()
                .filter(racingCar -> racingCar.getPosition() == winnerRecord)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
