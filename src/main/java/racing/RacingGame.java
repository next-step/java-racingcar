package racing;

import java.util.*;

public class RacingGame {

    private final static int RANDOM_VALUE_MAX = 10;
    List<Car> cars = null;

    public static int generateRandomValue() { return new Random().nextInt(RANDOM_VALUE_MAX); }

    public static List<Car> race(List<Car> cars) {
        for (Car car : cars) {
            car.move(generateRandomValue());
        }
        return cars;
    }

    public RacingGame(int numberOfCar) {
        this.cars = new ArrayList<Car>(numberOfCar);
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(i, new Car(0));
        }
    }

    public List<Car> getCars() { return cars; }

}
