package step3.domain.car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

    public static final String WINNER_SIZE_ERROR_MESSAGE = "우승자는 한명이상이어야 합니다.";

    private static final int MIN_WINNER_COUNT = 1;

    private final List<Car> cars;

    public Winners(List<Car> cars) {
        if (cars == null || cars.size() < MIN_WINNER_COUNT) {
            throw new IllegalArgumentException(WINNER_SIZE_ERROR_MESSAGE);
        }
        this.cars = cars;
    }

    public List<Name> getWinnersName() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
