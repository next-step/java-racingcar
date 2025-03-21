package racingcar;

import exception.NoCarException;
import util.RandomNumberGenerator;
import util.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move(int tryCounts) {
        ResultView.showResultMessage();
        for (int index = 0; index < tryCounts; index++) {
            move();
            ResultView.showCarGameResult(cars);
        }
    }

    public void move() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (Car car : cars) {
            car.move(randomNumberGenerator);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        Car maxCar = max();
        return cars.stream()
                .filter(car -> maxCar.isSameDistance(car.getDistance()))
                .collect(Collectors.toList());
    }

    private Car max() {
        return cars.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoCarException("빈 자동차입니다."));
    }
}
