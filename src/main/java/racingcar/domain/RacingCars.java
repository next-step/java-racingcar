package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

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

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public List<Car> getWinnerCars() {
        int winnerPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.hasSamePosition(winnerPosition))
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