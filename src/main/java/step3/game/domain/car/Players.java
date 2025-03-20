package step3.game.domain.car;

import step3.game.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static step3.game.domain.RandomGenerator.getRandomValue;

public class Players {

    private final Set<Car> cars = new HashSet<>();

    private Players() {}

    public Players(Set<Car> cars) {
        this.cars.addAll(cars);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void takeTurn() {
        Set<Car> updatedCars = new HashSet<>();
        for (Car car : cars) {
            updatedCars.add(makeMove(car));
        }
        cars.clear();
        cars.addAll(updatedCars);
    }

    private Car makeMove(Car car) {
        if (RacingCarGame.isMove(getRandomValue())) {
            return car.move();
        }
        return car;
    }

    public List<String> finalResult() {
        int maxDistance = getMaxDistance();
        return getWinners(maxDistance);
    }

    private List<String> getWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSame(maxDistance)) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.getMax(maxDistance);
        }
        return maxDistance;
    }
}
