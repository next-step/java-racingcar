package racingcarbasic;

import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> moveCars(List<Car> carList) {
        carList.stream()
                .forEach(car -> {
                    car.setMoveStrategy(new StraightMove());
                    car.move();
                });

        return carList;
    }
}

