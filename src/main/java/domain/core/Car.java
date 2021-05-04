package domain.core;

public class Car {
    private final CarName carName;
    private final Distance distance;

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance();
    }

    public void move(Accelerator accelerator) {
        if (accelerator.isDriving()) {
            distance.increaseDistance();
        }
    }

    public String getName() {
        return carName.getName();
    }

    public String getDistancePrintMessage() {
        return distance.getDistancePrintMessage();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
