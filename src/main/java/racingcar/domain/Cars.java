package racingcar.domain;

import racingcar.rule.MovableRuleGenerator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(int distance, MovableRuleGenerator rule) {
        for (Car car : this.cars) {
            if (rule.isMovable()) {
                car.move(distance);
            }
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getBestPosition();

        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getBestPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
    }

    public List<Car> getCarsToList() {
        List<Car> cloneCars = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            cloneCars.add(cars.get(i).clone());
        }
        return cloneCars;
    }

    public Cars getCurrentCars() {
        return new Cars(getCarsToList());
    }
}
