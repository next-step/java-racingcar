package racingcar.domain.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.domain.exception.HistoryOutOfBoundsException;
import racingcar.domain.model.Car;

public class Winners {

    private List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners from(List<Car> cars) {
        return new Winners(cars);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(getWinners(getSuccessMax()));
    }

    private long getSuccessMax() {
        return cars.stream()
            .mapToLong(Car::getHistorySuccessCount)
            .max()
            .orElseThrow(HistoryOutOfBoundsException::new);
    }

    private List<Car> getWinners(long max) {
        return cars.stream()
            .filter(car -> car.getHistorySuccessCount() == max)
            .collect(Collectors
                .toCollection(ArrayList::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
