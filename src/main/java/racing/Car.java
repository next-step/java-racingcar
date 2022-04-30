package racing;

import java.util.ArrayList;
import java.util.Random;

public class Car {
    private static final int START_MOVE_VALUE = 0;
    private static final int MAX_BOUND = 10;
    private static final int CRITERION_VALUE = 4;
    private static final Random random = new Random();

    Integer carKey;
    Integer position;

    public Car(Integer carKey, Integer position) {
        this.carKey = carKey;
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public static ArrayList<Car> initCars(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(i, START_MOVE_VALUE));
        }
        return cars;
    }

    public static ArrayList<Car> moveCars(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    private void move() {
        this.position += moveRandom();
    }

    private static int moveRandom() {
        if (random.nextInt(MAX_BOUND) >= CRITERION_VALUE) {
            return 1;
        }
        return 0;
    }
}
