package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int numberOfCars) {
        this(numberOfCars, new RandomMovementStrategy());
    }

    public RacingGame(int numberOfCars, CarMovementStrategy carMovementStrategy) {
        this.cars = joinCars(numberOfCars, carMovementStrategy);
    }

    private List<Car> joinCars(int numberOfCars, CarMovementStrategy carMovementStrategy) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(carMovementStrategy));
        }

        return cars;
    }

    public List<Car> getResult(int numberOfAttempts) {
        for (int i = 0; i < numberOfAttempts; i++) {
            move();
        }

        return this.cars;
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

}
