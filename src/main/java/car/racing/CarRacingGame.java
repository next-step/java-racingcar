package car.racing;

import car.racing.domain.Car;

import java.util.List;
import java.util.Random;

public class CarRacingGame {

    private static final int LIMIT = 10;

    private final Forwardable forwardable;
    private final List<Car> cars;
    private final Random random = new Random();

    public CarRacingGame(List<Car> cars, Forwardable forwardable) {
        this.cars = cars;
        this.forwardable = forwardable;
    }

    public void forwardCarEachTry() {
        cars.stream()
                .filter(car -> forwardable.forwardable(random.nextInt(LIMIT)))
                .forEach(Car::forward);
    }

    public List<Car> getCars() {
        return cars;
    }
}