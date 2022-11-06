package racinggame.domain;

import racinggame.strategy.MoveStrategy;
import racinggame.strategy.RandomMoveStrategy;

import java.util.Objects;

public final class Car implements Comparable<Car>{
    private final MoveStrategy moveStrategy;
    private final CarName carName;
    private Position position;


    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this(carName, position, new RandomMoveStrategy());
    }

    public Car(String carName, int position, MoveStrategy moveStrategy) {
        this.carName = new CarName(carName);
        this.position = new Position(position);
        this.moveStrategy = moveStrategy;
    }

    public void moveForward() {
        if (moveStrategy.movable()) {
            this.position = this.position.increase();
        }
    }

    public boolean isWinner(Position maxPosition){
        return this.position.equals(maxPosition);
    }

    public CarName getCarName(){
        return this.carName;
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public int compareTo(Car o) {
        return o.position.compareTo(this.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveStrategy, carName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "moveStrategy=" + moveStrategy +
                ", carName=" + carName +
                ", position=" + position +
                '}';
    }
}
