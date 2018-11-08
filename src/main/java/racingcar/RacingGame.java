package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> cars;
    private RandomProvider randomProvider;

    public RacingGame() {
        cars = new ArrayList<>();
        randomProvider = new RandomProvider();
    }

    public void readyCars(String carNames) {
        cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> startRacing() {
        for (Car car : cars) {
            car.move(randomProvider.getRandom());
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
