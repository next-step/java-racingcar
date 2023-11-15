package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> race(MoveStrategy moveStrategy) {
        moveCars(moveStrategy);
        return cars;
    }

    private void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            isMoveAble(moveStrategy, car);
        }
    }

    private static void isMoveAble(MoveStrategy moveStrategy, Car car) {
        if (moveStrategy.moveAble()) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
