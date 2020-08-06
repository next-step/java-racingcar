package racingcar;

public class GameInputs {
    private final int numberOfCars;
    private final int numberOfTrials;

    private GameInputs(int numberOfCars, int numberOfTrials) {
        this.numberOfCars = numberOfCars;
        this.numberOfTrials = numberOfTrials;
    }

    public static GameInputs createGameInputs(int numberOfCars, int numberOfTrials) {
        return new GameInputs(numberOfCars, numberOfTrials);
    }

    public int getNumberOfCars() {
        return this.numberOfCars;
    }

    public int getNumberOfTrials() {
        return this.numberOfTrials;
    }
}
