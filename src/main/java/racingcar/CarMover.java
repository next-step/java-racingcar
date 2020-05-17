package racingcar;

import java.util.List;

public class CarMover {

    private MoveStrategy moveStrategy;

    public CarMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int[] move(List<Car> cars) {
        int[] carPositions = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            move(car);
            carPositions[i] = car.getPosition();
        }

        return carPositions;
    }

    private void move(Car car) {
        if (moveStrategy.canMove()) {
            car.move();
        }
    }
}
