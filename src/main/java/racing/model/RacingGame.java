package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();

    public RacingGame(String[] names) {
        this(names, new RandomMovementStrategy());
    }

    public RacingGame(String[] names, CarMovementStrategy carMovementStrategy) {
        this.cars = joinCars(names, carMovementStrategy);
    }

    private List<Car> joinCars(String[] names, CarMovementStrategy carMovementStrategy) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name, carMovementStrategy));
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
