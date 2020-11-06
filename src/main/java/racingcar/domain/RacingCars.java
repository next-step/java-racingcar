package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.behavior.MovingStrategy;

public class RacingCars {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    private RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCars of(String[] nameOfCars, MovingStrategy movingStrategy) {
        int size = nameOfCars.length;
        List<Car> initCars = createCars(nameOfCars, size);
        return new RacingCars(initCars, movingStrategy);
    }

    private static List<Car> createCars(String[] nameOfCars, int numOfCar) {
        List<Car> carsWithName = new ArrayList<>();
        for (int i = 0; i < numOfCar; i++) {
            String carName = nameOfCars[i];
            carsWithName.add(new Car(carName));
        }
        return carsWithName;
    }

    public void run() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(final Car car) {
        car.move(movingStrategy);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}