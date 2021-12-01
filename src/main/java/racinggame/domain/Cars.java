package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private RandomValue getRandomNo() {
        Random random = new Random();
        return new RandomValue(random.nextInt(MAX_BOUND));
    }

    public List<Car> findWinners() {
        return getWinners(getMaxPosition());
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position(0);
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
