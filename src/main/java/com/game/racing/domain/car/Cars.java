package com.game.racing.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.game.racing.domain.car.Winner.getWinnerPosition;

public class Cars {

    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        addNewCarsWithNames(carNames);
    }

    private void addNewCarsWithNames(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public int getTotalCarSize() {
        return cars.size();
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public List<Car> getRacingWinners() {
        return cars.stream()
                .filter(car -> car.getPosition().get() == getWinnerPosition())
                .collect(Collectors.toUnmodifiableList());
    }

}
