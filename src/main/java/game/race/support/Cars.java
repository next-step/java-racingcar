package game.race.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.race.Car;
import game.race.support.move.MovePolicy;

public class Cars {

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public List<Car> of(List<String> vehicleNames) {
        cars.addAll(vehicleNames.stream()
                                .map(Car::new)
                                .collect(Collectors.toList()));

        return cars;
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
        int maxMoveCount = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        for (Car car : cars) {
            addWinner(car, maxMoveCount, winners);
        }

        return winners;
    }

    private void addWinner(Car car,
                           int maxMoveCount,
                           List<String> winners) {
        if (maxMoveCount == car.getMoveCount()) {
            winners.add(car.getName());
        }
    }
}
