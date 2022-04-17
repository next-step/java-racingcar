package racing.controller;

import racing.domain.Car;
import racing.util.ForwardUtil;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingCarController {

    public void startGame() {
        InputView inputView = new InputView();
        int carNumber = inputView.inputCarNumber();
        int moveCount = inputView.inputMoveNumber();

        Car[] cars = makeCars(carNumber);

        ResultView resultView = new ResultView();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                int value = getRandomValue();
                car.addDistance(getDistance(value));
            }
            resultView.printCarsPosition(cars);
        }
    }

    private Car[] makeCars(int carNumber) {
        Car[] cars = new Car[carNumber];
        for (int j = 0; j < carNumber; j++) {
            cars[j] = new Car();
        }
        return cars;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int getDistance(int value) {
        if(ForwardUtil.isAvailableForward(value)) {
            return 1;
        }
        return 0;
    }

}
