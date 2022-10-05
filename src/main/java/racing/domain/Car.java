package racing.domain;

public class Car {

    private int distance;

    public Car() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void move(MovableStrategy movableStrategy) {
        distance += movableStrategy.randomMovable();
    }

}
