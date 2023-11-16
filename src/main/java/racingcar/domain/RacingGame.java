package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private MoveStrategy moveStrategy;

    public RacingGame(String[] carNames) {
        this(carNames, new RandomNumberMoveStrategy());
    }
    public RacingGame(String[] carNames, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> race() {
        moveCars(moveStrategy);
        return cars;
    }

    private void moveCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            isMoveAble(moveStrategy, car);
        }
    }

    private void isMoveAble(MoveStrategy moveStrategy, Car car) {
        car.move(moveStrategy);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
