package race.domain;

public class Car {

    private final MovePolicy movePolicy;
    private int distance;

    public Car(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
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
}
