package race.domain;

public class Car {

    private final MovePolicy movePolicy;
    private final CarName carName;
    private int distance;

    public Car(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
        this.carName = null;
    }

    public Car(CarName carName, MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
        this.carName = carName;
    }

    public void move() {
        addDistance(movePolicy.move());
    }

    public int getMovedDistance() {
        return distance;
    }

    private void addDistance(int distance) {
        this.distance += distance;
    }

    public String getName() {
        if (carName == null) {
            return "";
        }
        return carName.get();
    }
}
