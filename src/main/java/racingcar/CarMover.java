package racingcar;

import java.util.List;

public class CarMover {

    private MoveStrategy moveStrategy;

    public CarMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarPositions move(List<Car> cars) {
        CarPositions carPositions = new CarPositions();

        for (Car car : cars) {
            move(car);
            carPositions.add(new CarPosition(car));
        }

        return carPositions;
    }

    private void move(Car car) {
        if (moveStrategy.canMove()) {
            car.move();
        }
    }
}
