package racingcar.model;

import racingcar.RandomManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private static final int MOVE_CONDITION = 3;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        this.cars.forEach(car -> car.move(isMovingForward(RandomManager.getInstance().getRandomValue())));
    }

    public static boolean isMovingForward(int value) {
        return value > MOVE_CONDITION;
    }

    public List<Car> getWinnerCars() {
        int maxDistance = getMaxDistance();
        return this.cars.stream()
                .filter(car -> car.isSameDistance(maxDistance))
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .map(Car::getDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("값이 없습니다."));
    }

    public List<Car> getCars() {
        return cars;
    }

}
