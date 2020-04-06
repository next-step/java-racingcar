package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> allCars;
    private List<Car> winners = new ArrayList<>();

    public Winner(List<Car> allCars) {
        this.allCars = allCars.stream()
                .map(Car::clone)
                .collect(Collectors.toList());;
    }

    private int maxPosition() {
        int maxPosition = 0;
        for (Car car : allCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> findWinnerNames() {
        int maxPosition = maxPosition();
        for (Car car : allCars) {
            this.addWinners(car, maxPosition);
        }
        return winners;
    }

    private void addWinners(Car nowCar, int maxPosition) {
        if (nowCar.isWinner(maxPosition)) {
            winners.add(nowCar);
        }
    }
}
