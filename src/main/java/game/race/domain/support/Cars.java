package game.race.domain.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.race.domain.Car;
import game.race.domain.support.move.MovePolicy;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> vehicleNames) {
        List<Car> carList = vehicleNames.stream()
                                        .map(Car::new)
                                        .collect(Collectors.toList());
        return new Cars(carList);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(MovePolicy policy) {
        for (Car car : cars) {
            car.move(policy);
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, getMaxMoveCount(), winners);
        }

        return winners;
    }

    private int getMaxMoveCount() {
        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

    private void addWinner(Car car,
                           int maxMoveCount,
                           List<String> winners) {
        if (maxMoveCount == car.getMoveCount()) {
            winners.add(car.getName());
        }
    }
}
