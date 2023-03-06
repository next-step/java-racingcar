package car.service;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Name;
import car.domain.RacingGame;
import car.domain.condition.RandomMovingStrategyImpl;
import car.ui.GameResult;
import car.ui.Winner;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    public GameResult<List<Winner>> start(String carNames, int moveCount) {
        validateMoveCount(moveCount);
        List<Car> participants = validateCarNames(carNames);
        Cars cars = Cars.of(participants);
        RacingGame racingGame = new RacingGame(new RandomMovingStrategyImpl(), cars);
        return racingGame.play(moveCount);
    }

    private List<Car> validateCarNames(String carNames) {
        String[] carNamesArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNamesArray) {
            Name name = new Name(carName);
            cars.add(new Car(name));
        }

        return cars;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동횟수는 1 이상이어야 합니다. moveCount: " + moveCount);
        }
    }
}
