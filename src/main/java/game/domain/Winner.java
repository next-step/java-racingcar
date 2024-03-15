package game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners = new ArrayList<>();
    private final List<Car> cars;
    private final int maxDistance;

    public Winner(List<Car> cars) {
        this.cars = cars;
        this.maxDistance = calcMaxDistance();
        selectWinners();
    }

    public List<Car> get() {
        return winners;
    }

    public String getName() {
        List<String> names = this.winners.stream().map(Car::getName).collect(Collectors.toList());
        return String.join(", ", names);
    }

    private int calcMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private void selectWinners() {
        for (Car car : cars) {
            checkIfWinnerAndAddToWinners(car);
        }
    }

    private void checkIfWinnerAndAddToWinners(Car car) {
        if (car.getDistance() == maxDistance) {
            this.winners.add(car);
        }
    }

    public int getSize() {
        return winners.size();
    }
}
