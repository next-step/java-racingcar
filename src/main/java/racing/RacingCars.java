package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static final int MAX_MOVABLE_RANGE = 9;
    private final List<Car> cars = new ArrayList<>();

    public static RacingCars create(List<Car> cars) {
        RacingCars racingCars = new RacingCars();
        racingCars.cars.addAll(cars);
        return racingCars;
    }

    public void moveCars() {
        for (Car car : this.cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (isMovable()) car.go();
    }

    private boolean isMovable() {
        return MoveStatus.GO == MoveStatus.findByNumber(NumberUtil.generateRandomNumberFromZeroToInputNumber(MAX_MOVABLE_RANGE));
    }

}
