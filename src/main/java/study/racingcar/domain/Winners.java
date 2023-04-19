package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static final String DELIMITER = ",";
    private final List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(Car car) {
        this.winners.add(car);
    }

    @Override
    public String toString() {
        return this.winners
                .stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(DELIMITER));
    }
}
