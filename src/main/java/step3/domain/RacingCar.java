package step3.domain;

import step3.domain.strategy.MovableStrategy;

public class RacingCar {
    private int UNIT_OF_FORWARD = 1;
    private final String name;
    private int position = 0;
    private final MovableStrategy movableStrategy;

    public RacingCar(final String name, final MovableStrategy movableStrategy) {
        this.name = name;
        this.movableStrategy = movableStrategy;
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
