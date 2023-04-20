package domain;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public Winners(Cars cars) {
        List<Car> winners = cars.checkCarWithFarthestDistance();

        this.winners =
                List.of(winners.stream()
                .map(Car::getCarName)
                .toArray(String[]::new));
    }

    public String makeWinnersString(String winnerDelimiter) {
        return String.join(winnerDelimiter, winners);
    }
}
