package carracing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<List<String>> carDistances;
    private final List<Car> winners;

    public GameResult(List<List<String>> carDistances, List<Car> winners) {
        this.carDistances = carDistances;
        this.winners = winners;
    }

    public List<List<String>> getCarDistances() {
        return carDistances;
    }

    public List<String> getWinners() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
