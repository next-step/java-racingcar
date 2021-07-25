package step4;

import java.util.List;

public class RacingGameConfiguration {

    final private List<String> carNames;
    final private int numberOfCars;
    final private int numberOfTurns;

    public RacingGameConfiguration(List<String> carNames, int numberOfCars, int numberOfTurns) {
        this.carNames = carNames;
        this.numberOfCars = numberOfCars;
        this.numberOfTurns = numberOfTurns;
    }

    public int getNumberOfCars() {
        return this.numberOfCars;
    }

    public int getNumberOfTurns() {
        return this.numberOfTurns;
    }
}
