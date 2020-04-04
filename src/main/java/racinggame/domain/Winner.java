package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> allCars;
    private int maxPosition;
    private List<Car> winners = new ArrayList<>();

    public Winner(List<Car> allCars) {
        this.allCars = allCars;
        this.maxPosition = maxPosition();
    }

    private int maxPosition() {
        int maxPosition = 0;
        for (Car car : allCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> findWinnerNames() {
        for (Car car : allCars) {
            this.addWinners(car, this.maxPosition);
        }
        return winners;
    }

    private void addWinners(Car nowCar, int maxPosition) {
        if (nowCar.isWinner(maxPosition)) {
            winners.add(nowCar);
        }
    }
}
