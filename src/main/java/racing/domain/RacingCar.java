package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class RacingCar {
    private List<Car> cars;

    private RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public static RacingCar of(List<Car> cars) {
        return new RacingCar(cars);
    }

    public static RacingCar createByUsers(List<String> users) {
        if (users == null || users.isEmpty()) {
            return new RacingCar(Collections.emptyList());
        }

        List<Car> cars = users.stream()
            .map(Car::create)
            .collect(Collectors.toList());
        return new RacingCar(cars);
    }
}
