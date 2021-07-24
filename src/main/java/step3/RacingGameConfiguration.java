package step3;

public class RacingGameConfiguration {

    private int numberOfCars;
    private int numberOfTurns;

    public RacingGameConfiguration(int numberOfCars, int numberOfTurns) {
        this.numberOfCars = numberOfCars;
        this.numberOfTurns = numberOfTurns;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }
}
