package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public List<Car> generateCars (int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> race() {
        moveCars();
        ResultView resultView = new ResultView();
        resultView.viewGame(cars);
        return cars;
    }
    private void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }
}
