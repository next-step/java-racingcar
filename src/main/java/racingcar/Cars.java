package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(InputView inputView, RandomNumGenerator rng) {
        createCars(inputView);
        moveTryCount(inputView, rng);
    }

    private void createCars(InputView inputView) {
        int carCount = inputView.getCarCount();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void moveTryCount(InputView inputView, RandomNumGenerator rng) {
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            moveOnce(inputView, rng);
        }
    }

    private void moveOnce(InputView inputView, RandomNumGenerator rng) {
        for (Car car : cars) {
            int randomNum = rng.generateNumberLessThanTen();
            boolean canRun = car.canRun(randomNum);
            car.move(canRun);
        }
    }
}