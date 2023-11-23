package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    public static final int RANDOM_BOUND = 10;
    private final List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.moveForward(getRandomValue());
        }
    }

    public List<String> findWinners() {
        return calculatePosition(getMaxPosition());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private int getRandomValue() {
        return new Random().nextInt(RANDOM_BOUND);
    }

    private List<String> calculatePosition(Position maxPosition) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : this.cars) {
            addWinners(maxPosition, car, winnerNames);
        }
        return winnerNames;
    }

    private void addWinners(Position maxPosition, Car car, List<String> winnerNames) {
        if (maxPosition.equals(car.getPosition())) {
            winnerNames.add(car.getName().toString());
        }
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
        for (Car car : this.cars) {
            maxPosition = comparePosition(maxPosition, car);
        }
        return maxPosition;
    }

    private Position comparePosition(Position maxPosition, Car car) {
        if (car.getPosition().comparePosition(maxPosition)) {
            maxPosition = car.getPosition();
        }
        return maxPosition;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
