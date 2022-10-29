package racingcar.race;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingCars {
    private static List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(String[] names) {
        List<Car> cars = Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(toList());

        return new RacingCars(cars);
    }

    public void racingStart(NumberGenerator numberGenerator) {
        for (Car car : racingCars) {
            car.move(numberGenerator);
        }
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
