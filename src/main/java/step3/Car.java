package step3;

import step3.dto.CarWentResult;
import step3.stretegy.DiceStrategy;
import step3.stretegy.MoveStrategy;

import java.util.Objects;

public class Car {

    private static final int INIT_DISTANCE = 0;

    private final int carNumber;

    private final MoveStrategy moveStrategy;

    private int distance;

    public Car(int carNumber) {
        this.carNumber = carNumber;
        this.moveStrategy = new DiceStrategy();
        this.distance = INIT_DISTANCE;
    }
    //For Test Code
    public Car(int carNumber, MoveStrategy moveStrategy) {
        this.carNumber = carNumber;
        this.moveStrategy = moveStrategy;
        this.distance = INIT_DISTANCE;
    }

    public CarWentResult go() {
        updateDistance(moveStrategy.isAbleToMove());
        return new CarWentResult(this.carNumber, this.distance);
    }

    public int getDistance() {
        return this.distance;
    }

    private int updateDistance(boolean goingPossibility) {
        return goingPossibility ? ++this.distance : this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber == car.carNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}
