package car_racing;


import java.util.Objects;

public class Car implements Movable {
    private Integer carNumber;

    private MovableStrategy movableStrategy;

    private MoveResult moveResult;

    public Car(Integer carNumber, MovableStrategy movableStrategy) {
        this.carNumber = carNumber;
        this.movableStrategy = movableStrategy;
        this.moveResult = new MoveResult();
    }

    @Override
    public MovableStrategy movableStrategy() {
        return movableStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        Car car = (Car) o;
        return carNumber.equals(car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public void tryMove() {
        moveResult.applyMoveResult(movableStrategy().canMove());
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }
}
