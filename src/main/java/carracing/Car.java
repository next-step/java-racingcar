package carracing;

public class Car {

    private final CarName carName;

    private int step = 0;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public Car(CarName carName) {
        this.carName = carName;
    }

    public CarName getCarName() {
        return this.carName;
    }

    public int getStep() {
        return step;
    }

    public void stepForward(StepForwardStrategy stepForwardStrategy) {
        if (stepForwardStrategy.stepForward()) {
            step += 1;
        }
    }
}
