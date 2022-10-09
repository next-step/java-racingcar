package racing_car_with_winner.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private final MoveResult moveResult;

    public Car(final CarName carName) {
        this.carName = carName;
        this.moveResult = new MoveResult();
    }

    public Car(final CarName carName, final MoveResult moveResult) {
        this.carName = carName;
        this.moveResult = moveResult;
    }

    public Car tryMove(MovableStrategy movableStrategy) {
        return new Car(this.carName, moveResult.move(movableStrategy.canMove()));
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public CarName getCarName() {
        return carName;
    }

    public boolean isInfrontOf(MoveResult moveResult) {
        return this.moveResult.compareTo(moveResult) >= 0;
    }

    public boolean isInfrontOf(Car car) {
        return this.moveResult.compareTo(car.moveResult) > 0;
    }

    public boolean isSameResult(Car car) {
        return this.moveResult.compareTo(car.moveResult) == 0;
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

    @Override
    public int compareTo(Car o) {
        return this.moveResult.compareTo(o.moveResult);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("carName=").append(carName);
        sb.append(", moveResult=").append(moveResult);
        sb.append('}');
        return sb.toString();
    }
}
