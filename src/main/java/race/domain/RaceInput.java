package race.domain;

import java.util.List;

public class RaceInput {
    private final int gameCount;
    private final List<String> carNames;

    public RaceInput(int gameCount, List<String> carNames) {
        this.gameCount = gameCount;
        this.carNames = carNames;
    }

    public int gameCount() {
        return this.gameCount;
    }

    public List<String> carNames() {
        return this.carNames;
    }
}
