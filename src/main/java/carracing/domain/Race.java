package carracing.domain;

import java.util.List;

import static carracing.utile.RandomNumberGenerator.getRandomNumber;

public class Race {

    public static List<Car> moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
        return cars;
    }

    private static void moveCar(Car car) {
        if (car.canMove(getRandomNumber())) {
            car.move();
        }
    }
}
