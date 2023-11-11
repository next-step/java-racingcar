package racingcar.domain;

import racingcar.strategy.MoveStrategy;
import racingcar.ui.RacingInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> carList() {
        return cars;
    }

    public List<String> maxPositionCars() {
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition()))
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::forwardCnt)
                .max()
                .getAsInt();
    }

    public void moveCars(MoveStrategy moveStrategy) {
        carList().forEach(car -> {
            if (moveStrategy.ableMove()) car.moveForward(moveStrategy.randomNumber());
        });
    }
}
