package step5.domain;

import step5.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;
    private int winPosition;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveableCheck(MoveStrategy moveStrategy) {
        cars.forEach(car -> {
            if (moveStrategy.move())
                car.move();
        });
    }

    public List<String> getWinCarNames() {
        calcWinPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void calcWinPosition() {
        winPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();
    }
}
