package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.behavior.MovingStrategy;

public class RacingCars {

    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public RacingCars(List<Car> cars, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public static RacingCars of(String [] numOfCar, MovingStrategy movingStrategy) {
        int size = numOfCar.length;
        List<Car> initCars = createCars(size);
        return new RacingCars(initCars, movingStrategy);
    }

    private static List<Car> createCars(int numOfCar) {
        return Stream.generate(Car::new)
                .limit(numOfCar)
                .collect(Collectors.toList());
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
