package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<Car> winners;
    private List<String> winnerNames;

    public GameResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        if (winnerNames == null) {
            winnerNames = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.toList());
        }
        return winnerNames;
    }
}
