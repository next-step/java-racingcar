package racingcarbasic;

import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public void moveCars(List<Car> carList) {
        carList.forEach(car -> {
                    car.setMoveStrategy(new StraightMove());
                    car.move();
                });
    }
}

