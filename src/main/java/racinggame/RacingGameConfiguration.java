package racinggame;

public class RacingGameConfiguration {

    private int numberOfCars;
    private int numberOfTries;

    public RacingGameConfiguration(int numberOfCars, int numberOfTries) {
        this.numberOfCars = numberOfCars;
        this.numberOfTries = numberOfTries;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}