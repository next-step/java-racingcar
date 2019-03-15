package racinggame;

public class Configuration {

    private String[] carNames;
    private int numberOfTries;

    public Configuration(String[] carNames, int numberOfTries) {
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