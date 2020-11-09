package car.racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingFactory {

    private static final String DELIMITER = ",";

    static CarRacingViewController newInstance(String names) {
        List<Car> cars = Arrays.stream(names.split(DELIMITER))
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        return new CarRacingViewController(
                new ResultView(),
                new CarRacingManager(cars, new CarForwardable()));
    }
}
