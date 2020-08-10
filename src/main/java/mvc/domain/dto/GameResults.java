package mvc.domain.dto;

import java.util.List;

public class GameResults {
    private final GameSteps steps;
    private final List<String> winners;

    private GameResults(GameSteps steps, List<String> winners) {
        this.steps = steps;
        this.winners = winners;
    }

    public GameSteps getSteps() {
        return this.steps;
    }

    public static GameResults createResult(GameSteps steps, List<String> winners) {
        return new GameResults(steps, winners);
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
