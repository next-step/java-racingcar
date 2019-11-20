package racingcarNew;

import racingcarNew.domain.Car;
import racingcarNew.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(String carNames, int racingLap) {
        cars = generateCars(carNames);
    }

    private Cars generateCars(String carNames) {
        String[] names = carNames.split(",");

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }

    public Cars racingCars() {
        return cars;
    }
}
