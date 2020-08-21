package racingcarbasic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public static RacingCars of (Integer carNum) {
        return new RacingCars(
                Stream.generate(() -> new Car("car", 0))
                .limit(carNum)
                .collect(Collectors.toList()));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars() {
        carList.forEach(car -> {
                    car.setMoveStrategy(new StraightMove());
                    car.move();
                });
    }
}

