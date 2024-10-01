package racinggame.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> cars;

    public RacingCars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(MoveStrategy strategy) {
        CarPosition carPosition = new CarPosition();
        RacingCar racingCar = new RacingCar(carPosition, strategy);
        cars.add(racingCar);
    }

    public boolean allCarsAtStartPosition() {
        return cars.stream().allMatch(RacingCar::isAtStartPosition);
    }

    public int count() {
        return cars.size();
    }
}