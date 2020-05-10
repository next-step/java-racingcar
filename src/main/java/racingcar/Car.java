package racingcar;

public class Car {

    private int position;
    private MovableStrategy movableStrategy;

    public Car(int position, MovableStrategy movableStrategy) {
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position += movableStrategy.move();
    }
}
