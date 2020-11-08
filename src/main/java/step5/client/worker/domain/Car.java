package step5.client.worker.domain;

import step5.client.worker.domain.strategy.MovableStrategy;

public class Car {
    private static final int UNIT_OF_FORWARD = 1;
    private static final int DEFAULT_POSITION = 0;
    private final String name;
    private final Position position;
    private final MovableStrategy movableStrategy;

    private Car(final String name, final MovableStrategy movableStrategy, final int initPosition) {
        this.name = name;
        this.position = Position.of(initPosition);
        this.movableStrategy = movableStrategy;
    }

    public static Car of(final String name, final MovableStrategy movableStrategy) {
        return of(name, movableStrategy, DEFAULT_POSITION);
    }

    public static Car of(final String name, final MovableStrategy movableStrategy, final int initPosition) {
        return new Car(name, movableStrategy, initPosition);
    }
    
    public Car clone() {
        return Car.of(name, movableStrategy, position.getValue()); 
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isPositionEqual(final int position) {
        return this.position.getValue() == position;
    }

    public boolean isMove() {
        return movableStrategy.isMove();
    }

    public void moveForward() {
        position.increase(UNIT_OF_FORWARD);
    }
}
