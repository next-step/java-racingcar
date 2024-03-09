package carracing.model;

public class Car {
    private int position;
    private MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public int position() {
        return this.position;
    }

    public void move() {
        position += movingStrategy.move();
    }
}
