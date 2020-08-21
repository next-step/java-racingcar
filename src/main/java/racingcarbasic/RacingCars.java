package racingcarbasic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {
    private final List<Car> carList;
    private MoveStrategy moveStrategy;

    public RacingCars(List<Car> carList, MoveStrategy moveStrategy) {
        this.carList = carList;
        this.moveStrategy = moveStrategy;
    }

    public static RacingCars of (Integer carNum, MoveStrategy moveStrategy) {
        return new RacingCars(
                Stream.generate(() -> new Car("car", 0))
                .limit(carNum)
                .collect(Collectors.toList()), moveStrategy);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars() {
        carList.forEach(car -> {
                    car.setMoveStrategy(moveStrategy);
                    car.move();
                });
    }
}

