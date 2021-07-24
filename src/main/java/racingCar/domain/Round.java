package racingCar.domain;

import racingCar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final List<Car> cars;
    private final int MIN_VALUE_BY_CAR = 1;
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Round(List<Car> cars) {
        validateCarsSize(cars);
        this.cars = cars;
    }

    private void validateCarsSize(List<Car> cars) {
        if(isCarsSizeOverZero(cars)) {
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

    public Car getCar(int carNumber) {
        return this.cars.get(carNumber);
    }

    public List<String> getFirstCar() {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for(Car car : cars) {
            maxDistance = judgeFirstCar(winners, car, maxDistance);
        }

        return winners;
    }

    private int judgeFirstCar(List<String> winners, Car car, int maxDistance) {
        if(car.getCarDistance() < maxDistance) {
            return maxDistance;
        }
        if(car.getCarDistance() == maxDistance) {
            winners.add(car.getCarName());
            return maxDistance;
        }
        winners.clear();
        winners.add(car.getCarName());
        return car.getCarDistance();
    }

}
