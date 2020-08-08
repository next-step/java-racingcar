package racingcar;

public class GameInputs {
    private final String[] names;
    private final int numberOfTrials;

    private GameInputs(String[] names, int numberOfTrials) {
        this.names = names;
        this.numberOfTrials = numberOfTrials;
    }

    public static GameInputs createGameInputs(String[] names, int numberOfTrials) {
        return new GameInputs(names, numberOfTrials);
    }

    public String[] getNameOfCars() {
        return this.names;
    }

    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }
}
