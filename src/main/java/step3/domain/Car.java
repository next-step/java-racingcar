package step3.domain;

import step3.runType.RunStrategy;

public class Car {

    private static final int HIGH_POWER_BOUNDARY = 4;
    private static final int ENGINE_POWER_LIMIT = 9;

    private final String carNumber;
    private int runDistance;
    private int enginePower;

    private RunStrategy runStrategy;


    public Car(String carNumber, RunStrategy runStrategy) {
        this.carNumber = carNumber;
        this.runStrategy = runStrategy;
    }

    public void run() {
        runDistance += this.runStrategy.run();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getRunDistance() {
        return runDistance;
    }

    private void prepareEngine() {
        enginePower = (int) (Math.random() * ENGINE_POWER_LIMIT);
    }
}
