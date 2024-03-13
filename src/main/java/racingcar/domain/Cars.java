package racingcar.domain;

import racingcar.dto.MoveResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int count, MoveStrategy moveStrategy) {
        for (int i = 0; i < count; i++) {
            this.cars.add(new Car(moveStrategy));
        }
    }

    public MoveResult move() {
        MoveResult moveResult = new MoveResult();
        for (Car car : cars) {
            Car movedCar = car.move();
            moveResult.addMoveLog(car.isMoved(movedCar));
        }

        return moveResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
