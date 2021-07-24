package step3.domain;

import step3.runType.RunStrategy;

public class Car {

    private final String carNumber;
    private int runDistance;

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

}
