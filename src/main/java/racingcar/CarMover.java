package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class CarMover {

    private MoveStrategy moveStrategy;

    public CarMover(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public CarPositions move(List<Car> cars) {
        List<CarPosition> positions = cars.stream()
                .map(c -> {
                    move(c);
                    return new CarPosition(c.getName(), c.getPosition());
                })
                .collect(Collectors.toList());

        return new CarPositions(positions);
    }

    private void move(Car car) {
        if (moveStrategy.canMove()) {
            car.move();
        }
    }
}
