package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinnerCars {

    private final List<Car> winnerCars;

    public WinnerCars(List<Car> winnerCars) {
        this.winnerCars = winnerCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerCars that = (WinnerCars) o;
        return Objects.equals(winnerCars, that.winnerCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerCars);
    }

    @Override
    public String toString() {
        return winnerCars.stream().map(Car::getCarName).collect(Collectors.joining(","));
    }
}
