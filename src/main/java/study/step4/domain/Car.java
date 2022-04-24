package study.step4.domain;

import study.step4.domain.strategy.MoveStrategy;
import study.step4.util.Comparable;

public class Car implements Comparable<Car> {
    private final CarName carName;
    private CarPosition carPosition;

    public Car(CarName carName) {
        this.carName = carName;
        this.carPosition = CarPosition.createDefault();
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.isMovable()) {
            carPosition = carPosition.forward();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }


    @Override
    public int compareTo(Car obj) {
        return carPosition.getPosition() - obj.carPosition.getPosition();
    }
}
