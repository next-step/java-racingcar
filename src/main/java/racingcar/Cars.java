package racingcar;

import exception.NoCarException;
import util.RandomNumberGenerator;
import util.ResultView;

import java.util.ArrayList;
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
            car.move(new RandomNumberGenerator());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.isWinner(maxDistance))
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new NoCarException("빈 자동차입니다."));
    }
}
