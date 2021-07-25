package step3;

public class RacingGameConfiguration {

    final private int numberOfCars;
    final private int numberOfTurns;

    public RacingGameConfiguration(int numberOfCars, int numberOfTurns) {
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
