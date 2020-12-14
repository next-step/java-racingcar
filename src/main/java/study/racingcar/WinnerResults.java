package study.racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerResults {

    private final List<Car> winners;

    public WinnerResults(List<Car> winners) {
        this.winners = Collections.unmodifiableList(winners);
    }

    public String getWinnerNames() {
        return winners.stream()
            .map(Car::getName)
            .map(Name::getName)
            .collect(Collectors.joining(", "));
    }
}
