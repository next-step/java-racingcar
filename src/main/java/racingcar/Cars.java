package racingcar;

import util.RandomNumberGenerator;
import util.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName: carNames) {
            Car car = new Car(carName);
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

    public List<Car> getCars() {
        return cars;
    }
}
