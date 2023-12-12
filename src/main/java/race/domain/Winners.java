package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final Cars cars;

    private final List<String> winners;

    public Winners(Cars cars) {
        this.cars = cars;
        winners = new ArrayList<>();
    }

    private void findWinners() {
        int maxPosition = cars.maxPosition();
        for (Car car : cars.cars()) {
            addWinners(car, maxPosition);
        }
    }

    private void addWinners(Car car, int maxPosition) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.name());
        }
    }

    public String getWinners() {
        findWinners();
        return String.join(",", winners);
    }

}
