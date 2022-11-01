package step3.domain;

import step3.common.CarNumber;
import step3.common.Position;
import step3.common.Positive;
import step3.common.RandomBounded;
import step3.strategy.MovableStrategy;
import step3.strategy.RandomMovableStrategy;

public class RacingCar {

    private static final int INITIAL_NUMBER = 0;

    private static final int INITIAL_POSITION = 0;
    
    private CarNumber carNumber;

    private Position position;

    public RacingCar() {
        this(INITIAL_NUMBER);
    }

    public RacingCar(int carNumber) {
        this(carNumber, INITIAL_POSITION);
    }

    public RacingCar(int carNumber, int position) {
        this.carNumber = new CarNumber(carNumber);
        this.position = new Position(position);
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            Positive p = position.plusOne();
            this.position = new Position(p.positive());
        }
    }

    public int carNumber() {
        return carNumber.positive();
    }

    public int position() {
        return position.positive();
    }

    public void raceCar() {
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        move(movableStrategy);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RacingCar && this.carNumber() == ((RacingCar) o).carNumber()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return carNumber() * 13;
    }
}
