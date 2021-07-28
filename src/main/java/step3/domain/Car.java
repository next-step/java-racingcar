package step3.domain;

import step3.runType.RunStrategy;

public class Car {

    private final CarName carName;
    private int runDistance;

    public Car(CarName carName) {
        this.carName = carName;
    }

    public void run(RunStrategy runStrategy) {
        runDistance += runStrategy.run();
    }

    public CarName getCarName() {
        return carName;
    }

    public int getRunDistance() {
        return runDistance;
    }

}
