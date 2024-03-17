package racingCar;

import java.util.List;
import java.util.Objects;

public class RacingCars {

    private final List<RacingCar> cars;

    private RacingRule rule;

    public RacingCars(List<RacingCar> cars) {
        this.cars = cars;
    }
    public RacingCars(List<RacingCar> cars, RacingRule rule){
        this.cars = cars;
        this.rule = rule;
    }

    public List<RacingCar> findCars() {
        return this.cars;
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(rule.isMovable());
        }
    }

    public int findFarthestLocation() {
        return cars.stream()
            .mapToInt(RacingCar::findCurrentLocation)
            .max()
            .getAsInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars) && Objects.equals(rule, that.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, rule);
    }
}
