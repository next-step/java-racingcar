package racingCar;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> cars;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> findCars() {
        return this.cars;
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(RacingRule.isMovable(RacingRule.generateRandomDistance()));
        }
    }
}
