package racing.domain;

import common.Verify;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarRacingInfo {

    private static final String RACE_NOT_COMPLETED_MESSAGE = "아직 레이스가 끝나지 않았습니다";
    private final CarRacing carRacing;
    private final List<Car> cars;

    public CarRacingInfo(CarRacing carRacing, List<Car> cars) {
        this.carRacing = carRacing;
        this.cars = cars;
    }

    public int getCarCount() {
        return cars.size();
    }

    public String[] getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String[] getWinners() {
        Verify.checkState(carRacing.isComplete(), RACE_NOT_COMPLETED_MESSAGE);
        return cars.stream()
                .filter(car -> car.getDistance() == getMaxMovedDistance())
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public int getMaxMovedDistance() {
        return Collections.max(cars, Comparator.comparingInt(Car::getDistance)).getDistance();
    }
}
