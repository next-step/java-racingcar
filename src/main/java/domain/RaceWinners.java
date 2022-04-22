package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RaceWinners {
    private static final String CARS_DELIMITER = ",";
    private final List<Car> winners;

    public RaceWinners(List<Car> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        List<String> winnersName = winners.stream()
                .map(Car::carName)
                .collect(Collectors.toList());

        return String.join(CARS_DELIMITER, winnersName);
    }
}

