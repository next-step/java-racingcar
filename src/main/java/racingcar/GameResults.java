package racingcar;

import java.util.List;

public class GameResults {
    private final GameStepList steps;
    private final List<String> winners;

    private GameResults(GameStepList steps, List<String> winners) {
        this.steps = steps;
        this.winners = winners;
    }

    public GameStepList getSteps() {
        return this.steps;
    }

    public static GameResults createResult(GameStepList steps, List<String> winners) {
        return new GameResults(steps, winners);
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
