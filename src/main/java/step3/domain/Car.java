package step3.domain;

public class Car {
    private int distance = 0;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(DecideMode mode) {
        moveSelectMode(mode);
    }

    public void move() {
        moveSelectMode(DecideMode.RANDOM_MODE);
    }

    private boolean decideForward(DecideMode mode) {
        return mode.isCanMove();
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    private void moveSelectMode(DecideMode mode) {
        if(decideForward(mode)) {
            distance++;
        }
    }
}
