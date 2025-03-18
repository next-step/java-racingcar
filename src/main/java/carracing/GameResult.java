package carracing;

import java.util.List;

public class GameResult {
    private final List<List<String>> carDistances;
    private final List<String> winners;

    public GameResult(List<List<String>> _carDistances, List<String> _winners) {
        carDistances = _carDistances;
        winners = _winners;
    }

    public List<List<String>> getCarDistances() {
        return carDistances;
    }

    public List<String> getWinners() {
        return winners;
    }
}
