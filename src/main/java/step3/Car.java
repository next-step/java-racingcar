package step3;

public class Car {
    private static final int INIT_DISTANCE = 0;

    private int distance;

    public Car() {
        this.distance = INIT_DISTANCE;
    }

    public void move(boolean canMove) {
        if(canMove) {
            this.distance++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
