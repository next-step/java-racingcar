package racing.controller;

import racing.domain.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarController {

    public void startGame() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.inputCarNames();
        int moveCount = inputView.inputMoveNumber();

        List<Car> cars = makeCars(carNames);

        ResultView resultView = new ResultView();

        for (int i = 0; i < moveCount; i++) {
            goStage(cars, resultView);
        }

        resultView.printWinners(getWinnerList(cars));

    }

    private void goStage(List<Car> cars, ResultView resultView) {
        for (Car car : cars) {
            int value = getRandomValue();
            car.move(value);
        }
        resultView.printCurrentStage(cars);
    }

    private List<Car> getWinnerList(List<Car> cars) {
        RacingWinner racingWinner = new RacingWinner();
        return racingWinner.getWinnerList(cars);
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
