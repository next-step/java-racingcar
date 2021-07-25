package step3.domain;

import step3.runType.RunStrategy;

public class Car {

    private final String carNumber;
    private int runDistance;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public void run(RunStrategy runStrategy) {
        runDistance += runStrategy.run();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getRunDistance() {
        return runDistance;
    }

}
