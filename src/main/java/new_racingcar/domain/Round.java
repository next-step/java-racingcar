package new_racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public List<Car> getRoundInfo() {
        return cars.getUnmodifiableCars();
    }

    public int getMaxDistance() {
        return getRoundInfo().stream()
                .mapToInt(Car::getDistance)
                .max()
                .getAsInt();
    }

    public String getWinnerNames(int maxDistance) {
        List<String> winners = getRoundInfo().stream()
                                    .filter(c -> c.getDistance() == getMaxDistance())
                                    .map(Car::getName)
                                    .collect(Collectors.toList());

        return String.join(",", winners);
    }
}
