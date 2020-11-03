package study.racingcar;

import study.racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    List<Car> cars;

    public GameResult(List<Car> cars) {
        this.cars = new ArrayList<>();
        cars.addAll(cars);
    }

    public Car getCars(int index) {
        if (index > getTotalCars() - 1) {
            throw new IllegalArgumentException("범위를 벗어난 Index입니다.");
        }

        return cars.get(index);
    }

    public int getTotalCars() {
        return cars.size();
    }

    public List<Car> hasMoreThanEqual(int position) {
        return cars.stream()
                .filter(car -> car.getCurrentPosition() > position)
                .collect(Collectors.toList());
    }
}
