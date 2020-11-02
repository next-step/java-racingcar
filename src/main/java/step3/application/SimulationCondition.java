package step3.application;

public class SimulationCondition {
    private final int numberOfCar;
    private final int numberOfAttempts;

    public SimulationCondition(final int numberOfCar, final int numberOfAttempts) {
        this.numberOfCar = numberOfCar;
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
