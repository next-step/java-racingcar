package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_BOUND = 10;

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.movedCar(getRandomNo()));
        }
        this.cars = movedCars;
    }

    private RandomValue getRandomNo() {
        Random random = new Random();
        return new RandomValue(random.nextInt(MAX_BOUND));
    }

    public List<Car> findWinners() {
        return getWinners(getMaxPosition());
    }

    private Position getMaxPosition() {
        Position maxPosition = Position.of(0);
        for (Car car : cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<Car> getWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
