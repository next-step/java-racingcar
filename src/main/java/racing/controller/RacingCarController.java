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
        int carNumber = inputView.inputCarNumber();
        int moveCount = inputView.inputMoveNumber();

        List<Car> cars = makeCars(carNumber);

        ResultView resultView = new ResultView();

        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                int value = getRandomValue();
                car.move(value);
            }
            resultView.printCarsPosition(cars);
        }
    }

    private List<Car> makeCars(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int j = 0; j < carNumber; j++) {
            cars.add(new Car());
        }
        return cars;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
