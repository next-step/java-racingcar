package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void tryMove() {
        cars.stream().forEach(Car::tryMove);
    }

    public List<Car> getWinners() {
        return cars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .map(car -> cars.stream()
                .filter(target->target.getPosition() == car.getPosition())
                .collect(Collectors.toList())
            )
            .orElse(Collections.EMPTY_LIST);
    }

    public List<Car> getCars(){
        return new ArrayList<>(cars);
    }
}
