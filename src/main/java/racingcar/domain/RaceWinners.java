package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RaceWinners {

    private final List<Car> winners;

    public RaceWinners(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> winnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceWinners that = (RaceWinners) o;
        return Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
