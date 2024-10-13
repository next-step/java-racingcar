package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingWinners {
    private final List<String> winners;

    public RacingWinners(List<String> cars) {
        winners = cars;
    }

    public RacingWinners(List<Car> cars, int maxPosition) {
        winners = new ArrayList<>();

        for (Car car : cars) {
            addWinner(car, maxPosition);
        }
    }

    private void addWinner(Car car, int maxPosition) {
        if (car.isWinner(maxPosition)) {
            winners.add(car.getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (o instanceof RacingWinners) {
            return Objects.equals(winners, ((RacingWinners) o).winners);
        }

        if (o instanceof List) {
            return winners.equals(o);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }

    @Override
    public String toString() {
        return String.join(",", winners);
    }
}
