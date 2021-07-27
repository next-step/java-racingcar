package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Round {

    private final List<Car> cars;
    private static final int MIN_VALUE_BY_CAR = 1;
    private static final String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Round(List<Car> cars) {
        validateCarsSize(cars);
        this.cars = cars;
    }

    private void validateCarsSize(List<Car> cars) {
        if (isCarsSizeOverZero(cars)) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private boolean isCarsSizeOverZero(List<Car> cars) {
        return cars.size() < MIN_VALUE_BY_CAR;
    }

    public Round startRound(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : this.cars) {
            movedCars.add(car.move(moveStrategy.isMoveable()));
        }
        return new Round(movedCars);
    }

    public int getCarsSize() {
        return this.cars.size();
    }

    public List<String> getFirstCar() {
        List<String> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car car : cars) {
            addWinner(winners, maxDistance, car);
        }
        return winners;
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .max(Comparator.comparing(Car::getCarDistance))
                .orElseGet(() -> new Car(new Name("temp")))
                .getCarDistance();
    }

    private void addWinner(List<String> winners, int maxDistance, Car car) {
        if (car.isSameCarDistance(maxDistance)) {
            winners.add(car.getCarName());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
