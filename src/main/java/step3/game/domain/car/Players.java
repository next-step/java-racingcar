package step3.game.domain.car;

import step3.game.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static step3.game.domain.RandomGenerator.getRandomValue;

public class Players {

    private final Set<Car> cars = new HashSet<>();

    public Players(Set<Car> cars) {
        this.cars.addAll(cars);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void takeTurn() {
        Set<Car> updatedCars = new HashSet<>();
        for (Car car : cars) {
            updatedCars.add(car.moveIfPossible(getRandomValue()));
        }
        cars.clear();
        cars.addAll(updatedCars);
    }

    public List<String> finalResult() {
        int maxDistance = getMaxDistance();
        return getWinners(maxDistance);
    }

    private List<String> getWinners(int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfMaxDistance(maxDistance, car, winners);
        }
        return winners;
    }

    private static void addWinnerIfMaxDistance(int maxDistance, Car car, List<String> winners) {
        if (car.isSame(maxDistance)) {
            winners.add(car.getCarName());
        }
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.getMax(maxDistance);
        }
        return maxDistance;
    }
}
