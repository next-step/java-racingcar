package step3;

public class Car {
    private int distance = 0;

    public void move(MovingStrategy strategy) {
        if (strategy.isForward()) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }
}
