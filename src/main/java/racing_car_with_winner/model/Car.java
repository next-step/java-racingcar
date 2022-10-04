package racing_car_with_winner.model;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private final MoveResult moveResult;

    public Car(CarName carName) {
        this.carName = carName;
        this.moveResult = new MoveResult();
    }

    public Car(CarName carName, MoveResult moveResult) {
        this.carName = carName;
        this.moveResult = moveResult;
    }

    public Car tryMove(MovableStrategy movableStrategy) {
        return new Car(this.carName, moveResult.move(movableStrategy.canMove()));
    }

    public MoveResult getMoveResult() {
        return moveResult;
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
        return carName.equals(car.carName) && moveResult.equals(car.moveResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, moveResult);
    }
}
