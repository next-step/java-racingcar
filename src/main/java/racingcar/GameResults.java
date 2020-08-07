package racingcar;

import java.util.List;
import java.util.Map;

public class GameResults {
    private final List<Map<String, Integer>> steps;
    private final List<String> winners;

    private GameResults(List<Map<String, Integer>> steps, List<String> winners) {
        this.steps = steps;
        this.winners = winners;
    }

    public List<Map<String, Integer>> getSteps() {
        return this.steps;
    }

    public static GameResults createResult(List<Map<String, Integer>> steps, List<String> winners) {
        return new GameResults(steps, winners);
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
