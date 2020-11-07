package step3.domain;

import step3.domain.strategy.MovableStrategy;

public class RacingCar {
    private static final int UNIT_OF_FORWARD = 1;
    private static final int DEFAULT_POSITION = 0; 
    private final String name;
    private int position;
    private final MovableStrategy movableStrategy;

    private RacingCar(final String name, final MovableStrategy movableStrategy, final int initPosition) {
        this.name = name;
        this.position = initPosition;
        this.movableStrategy = movableStrategy;
    }
    
    public static RacingCar of(final String name, final MovableStrategy movableStrategy) {
        return of (name, movableStrategy, DEFAULT_POSITION);
    }

    public static RacingCar of(final String name, final MovableStrategy movableStrategy, final int initPosition) {
        return new RacingCar(name, movableStrategy, initPosition);
    }
    
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
    
    public boolean isPositionEqual(final int position) {
        return this.position == position;
    }

    public boolean isMove() {
        return movableStrategy.isMove();
    }

    public void moveForward() {
        position += UNIT_OF_FORWARD;
    }
    
    public CarRacingResult createRacingResult() {
        return new CarRacingResult(name, position);
    }
}
