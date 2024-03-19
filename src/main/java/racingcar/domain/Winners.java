package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private static final String DELIMITER = ", ";

    private final List<String> winners;

    public Winners(Cars cars) {
        this.winners = new ArrayList<>();
        choiceWinner(cars);
    }

    private void choiceWinner(Cars cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        for (Car car : cars) {
            pickWinners(car, maxDistance);
        }
    }

    private void pickWinners(Car car, int distance) {
        String carName = car.getName();
        if (car.matchDistance(distance)) {
            winners.add(carName);
        }
    }

    public String getWinnersNames() {
        return String.join(DELIMITER, winners);
    }
}
