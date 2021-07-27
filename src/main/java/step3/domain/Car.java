package step3.domain;

import step3.runType.RunStrategy;

public class Car {

    private final String carName;
    private int runDistance;

    public Car(String carName) {
        this.carName = carName;
    }

    public void run(RunStrategy runStrategy) {
        runDistance += runStrategy.run();
    }

    public String getCarName() {
        return carName;
    }

    public int getRunDistance() {
        return runDistance;
    }

}
