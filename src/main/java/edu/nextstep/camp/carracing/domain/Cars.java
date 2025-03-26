package edu.nextstep.camp.carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static edu.nextstep.camp.carracing.util.RandomNumberGenerator.generateRandomNumber;

public class Cars {
    private final List<Car> values;

    public Cars(List<Car> cars) {
        this.values = cars;
    }

    public static Cars fromNames(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void moveCars() {
        for (Car car : this.values) {
            car.move(generateRandomNumber());
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.values) {
            maxPosition = car.getMaxValue(maxPosition);
        }
        return maxPosition;
    }

    public List<String> getWinners() {
        int winnerPosition = getMaxPosition();
        return this.values.stream()
                .filter(car -> car.isMaxPosition(winnerPosition))
                .map(Car::getNameValue)
                .collect(Collectors.toList());
    }

    public List<Car> getValues() {
        return this.values;
    }
}
