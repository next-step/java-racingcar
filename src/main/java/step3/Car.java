package step3;

import step3.dto.CarWentResult;
import step3.stretegy.Dice;
import step3.stretegy.MoveStrategy;

import java.util.Objects;

public class Car {

    private final Integer carNumber;

    private final MoveStrategy moveStrategy;

    private Integer distance;

    public Car(Integer carNumber) {
        this.carNumber = carNumber;
        this.moveStrategy = new Dice();
        this.distance = 0;
    }
    //For Test Code
    public Car(MoveStrategy moveStrategy) {
        this.carNumber = 0;
        this.moveStrategy = moveStrategy;
        this.distance = 0;
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
