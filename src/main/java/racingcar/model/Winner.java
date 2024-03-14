package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<String> winners;

    public Winner(Cars cars) {
        this.winners = new ArrayList<>();
        choiceWinner(cars);
    }

    private void choiceWinner(Cars cars) {
        int maxDistance = 0;

        for (Car car : cars) {
            int distance = car.getDistance();
            maxDistance = compareDistance(distance, maxDistance);
        }

        for (Car car : cars) {
            pickWinners(car, maxDistance);
        }
    }

    private int compareDistance(int carDistance, int distance) {
        if (carDistance >= distance) {
            return carDistance;
        }
        return distance;
    }

    private void pickWinners(Car car, int distance) {
        String carName = car.getCarName();
        if (car.matchDistance(distance)) {
            winners.add(carName);
        }
    }

    public String getWinnerNames() {
        String winnerName = String.join(", ", winners);
        return winnerName;
    }
}
