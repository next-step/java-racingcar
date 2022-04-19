package racing.controller;

import racing.domain.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarController {

    public void startGame() {
        InputView inputView = new InputView();
        List<String> carNames = inputView.inputCarNames();
        int moveCount = inputView.inputMoveNumber();

        List<Car> cars = makeCars(carNames);

        ResultView resultView = new ResultView();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                int value = getRandomValue();
                car.move(value);
            }
            resultView.printCarsPosition(cars);
        }

        resultView.printWinners(getWinnerList(cars));

    }

    private List<Car> getWinnerList(List<Car> cars) {
        RacingWinner racingWinner = new RacingWinner();
        return racingWinner.getWinnerList(cars);
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
