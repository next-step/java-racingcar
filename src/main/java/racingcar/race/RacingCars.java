package racingcar.race;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private static List<Car> racingCars;

    public RacingCars(List<Car> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (int carIndex = 0; carIndex < names.length; carIndex++) {
            cars.add((new Car(names[carIndex], 0)));
        }

        return new RacingCars(cars);
    }

    public static void addCar(Car car) {
        racingCars.add(car);
    }

    public void racingStart(NumberGenerator numberGenerator) {
        for (Car car : racingCars) {
            car.move(numberGenerator);
        }
    }

    public static List<Car> getRacingCars() {
        return racingCars;
    }
}
