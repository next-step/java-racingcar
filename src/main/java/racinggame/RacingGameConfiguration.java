package racinggame;

public class RacingGameConfiguration {

    private String [] carNames;
    private int numberOfTries;

    public RacingGameConfiguration(String [] carNames, int numberOfTries) {
        this.carNames = carNames;
        this.numberOfTries = numberOfTries;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumberOfTries() {
        return numberOfTries;
    }
}