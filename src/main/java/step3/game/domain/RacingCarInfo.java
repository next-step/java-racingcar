package step3.game.domain;

import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;

import java.util.HashSet;
import java.util.Set;

public class RacingCarInfo {
    public final Set<Car> cars;
    public final Integer tryCount;

    private RacingCarInfo(Set<Car> cars, Integer tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public static RacingCarInfo getCars(Set<CarName> carNames, PositiveNumber tryCount) {
        Set<Car> cars = new HashSet<>();
        for (CarName carName : carNames) {
            cars.add(new Car(carName));
        }
        return new RacingCarInfo(cars, tryCount.number);
    }
}
