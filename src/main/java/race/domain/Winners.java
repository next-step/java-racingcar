package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final Cars cars;

    private final List<String> winners;

    private int maxPosition;

    public Winners(Cars cars) {
        this.cars = cars;
        maxPosition = 0;
        winners = new ArrayList<>();
    }

    private void findWinners() {
        calculateMaxPosition();
        for (Car car : cars.getCars()) {
            addWinners(car);
        }
    }

    private void calculateMaxPosition() {
        for (Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }

    private void addWinners(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    public String getWinners() {
        findWinners();
        return String.join(",", winners);
    }

}
