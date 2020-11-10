package car.racing;

import car.racing.domain.Car;
import car.racing.domain.CarRacingGame;
import car.racing.domain.CarRacingWinners;
import car.racing.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingFactory {

    private static final String DELIMITER = ",";

    public static CarRacingViewController newInstance(String names) {
        List<Car> cars = Arrays.stream(names.split(DELIMITER))
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

        return new CarRacingViewController(
                new ResultView(),
                new CarRacingGame(cars, new CarForwardable()),
                new CarRacingWinners(cars));
    }
}
