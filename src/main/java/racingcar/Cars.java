package racingcar;

import util.RandomNumberGenerator;
import util.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCounts) {
        cars = new ArrayList<>();
        for (int index = 0; index < carCounts; index++) {
            Car car = new Car();
            cars.add(car);
        }
    }

    public void move(int tryCounts) {
        ResultView.showResultMessage();
        for (int index = 0; index < tryCounts; index++) {
            move();
            getCarResults();
        }
    }

    public void getCarResults() {
        ResultView.showCarGameResult(cars);
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.getRandomNumber();
            car.move(randomNumber);
        }
    }
}
