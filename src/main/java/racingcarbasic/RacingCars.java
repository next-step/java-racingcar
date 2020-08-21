package racingcarbasic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> carList;
    private final MoveStrategy moveStrategy;

    public RacingCars(List<Car> carList, MoveStrategy moveStrategy) {
        this.carList = carList;
        this.moveStrategy = moveStrategy;
    }

    public static RacingCars of(String[] carNameList, MoveStrategy moveStrategy) {
        return new RacingCars(
                Arrays.stream(carNameList)
                        .map(name -> new Car(name, 0))
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

