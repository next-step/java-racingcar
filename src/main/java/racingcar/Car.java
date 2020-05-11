package racingcar;

import java.util.Objects;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private int position;
    private MovableStrategy movableStrategy;

    public Car(int position, MovableStrategy movableStrategy) {
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    public static Car newInstance() {
        return new Car(DEFAULT_POSITION, new RandomMovableStrategy());
    }

    public int getPosition() {
        return position;
    }

    public MovableStrategy getMovableStrategy() {
        return movableStrategy;
    }

    public int move() {
        validate();
        this.position += movableStrategy.move();
        return position;
    }

    private void validate(){
        if(position < DEFAULT_POSITION || Objects.isNull(movableStrategy)) {
            throw new IllegalArgumentException();
        }
    }
}
