package carracing.domain;

import java.util.List;

public class GameResult {
    private final List<List<String>> carDistances;
    private final List<String> winners;

    public GameResult(List<List<String>> carDistances, List<String> winners) {
        this.carDistances = carDistances;
        this.winners = winners;
    }

    public List<List<String>> getCarDistances() {
        return carDistances;
    }

    public List<String> getWinners() {
        return winners;
    }
}
