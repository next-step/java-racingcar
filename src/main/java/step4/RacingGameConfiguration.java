package step4;

import java.util.List;

public class RacingGameConfiguration {

    final private List<String> carNames;
    final private int numberOfTurns;

    public RacingGameConfiguration(List<String> carNames, int numberOfTurns) {
        this.carNames = carNames;
        this.numberOfTurns = numberOfTurns;
    }

    public List<String> getCarNames() {
        return this.carNames.subList(0, this.carNames.size());
    }

    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }
}
