package racingcar.domain;

import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {
    private StringBuilder stringBuilder = new StringBuilder();
    private String winner = "";

    public RacingGame() {
    }

    public RacingGame(Cars cars, int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            cars.move();
        }
    }

    public void findWinnerCar(int maxPosition, List<Car> cars) {
        for (Car car : cars) {
            maxPositionCarName(maxPosition, car);
        }
    }

    public void printWinners() {
        ResultView resultView = new ResultView();
        resultView.gameResult(winner);
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

