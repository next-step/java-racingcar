package step3.domain;

public class Car {

    private int distance;

    public void move(boolean canMove) {
        if (canMove) {
            distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
