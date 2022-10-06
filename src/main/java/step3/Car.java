package step3;

public class Car {

    private int location;

    private final MovableStrategy movableStrategy;

    public Car(MovableStrategy movableStrategy) {
        this.location = 0;
        this.movableStrategy = movableStrategy;
    }

    public int location() {
        return this.location;
    }

    public void moveOrStop() {
        if (this.movableStrategy.isMovable()) {
            this.location++;
        }
    }
}
