package step5;

import step5.dto.CarWentResult;
import step5.stretegy.DiceStrategy;
import step5.stretegy.MoveStrategy;

import java.util.Objects;

public class Car {

    private static final int INIT_DISTANCE = 0;

    private final String carName;

    private final MoveStrategy moveStrategy;

    private int distance;

    public Car(String carName) {
        this.carName = carName;
        this.moveStrategy = new DiceStrategy();
        this.distance = INIT_DISTANCE;
    }
    //For Test Code
    public Car(String carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.moveStrategy = moveStrategy;
        this.distance = INIT_DISTANCE;
    }

    public CarWentResult go() {
        updateDistance(moveStrategy.isAbleToMove());
        return new CarWentResult(this.carName, this.distance);
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
        return carName == car.carName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
