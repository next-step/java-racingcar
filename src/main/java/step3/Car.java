package step3;

import step3.dto.CarWentResult;
import step3.stretegy.Dice;
import step3.stretegy.MoveStrategy;

import java.util.Objects;

public class Car {

    private static final Integer INIT_DISTANCE = 0;

    private final Integer carNumber;

    private final MoveStrategy moveStrategy;

    private Integer distance;

    public Car(Integer carNumber) {
        this.carNumber = carNumber;
        this.moveStrategy = new Dice();
        this.distance = INIT_DISTANCE;
    }
    //For Test Code
    public Car(Integer carNumber, MoveStrategy moveStrategy) {
        this.carNumber = carNumber;
        this.moveStrategy = moveStrategy;
        this.distance = INIT_DISTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carNumber.equals(car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    public CarWentResult go() {
        updateDistance(moveStrategy.isAbleToMove(moveStrategy.attemptMove()));
        return new CarWentResult(this.carNumber, this.distance);
    }

    public Integer getDistance() {
        return this.distance;
    }

    private Integer updateDistance(boolean goingPossibility) {
        return goingPossibility ? ++this.distance : this.distance;
    }

}
