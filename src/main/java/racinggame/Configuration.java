package racinggame;

import java.util.List;

public class Configuration {

    private List<String> carNames;
    private int numberOfTries;

    public Configuration(List<String> carNames, int numberOfTries) {
        this.carNames = carNames;
        this.numberOfTries = numberOfTries;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}