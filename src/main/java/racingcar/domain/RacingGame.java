package racingcar.domain;

import racingcar.ResultView;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingGame {
    private StringBuilder stringBuilder = new StringBuilder();
    private String winner = "";

    public RacingGame(Cars cars, int numberOfGames) {
        ResultView resultView = new ResultView();

        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
        }
        findWinnerCar(cars.maxPosition(), cars.getCars());
        resultView.gameResult(winner);
    }

    private void findWinnerCar(int maxPosition, List<Car> cars) {
        for (Car car : cars) {
            maxPositionCarName(maxPosition, car);
        }
    }

    private void maxPositionCarName(int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            saveWinnerCarNames(car);
        }
    }

    private void saveWinnerCarNames(Car car) {
        if (winner != "") {
            stringBuilder.append(", ");
        }
        winner = stringBuilder.append(car.getCarName()).toString();
    }
}

