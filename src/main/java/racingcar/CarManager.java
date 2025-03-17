package racingcar;

import java.util.Random;

public class CarManager {

    public static final int MAX_RAND_VALUE = 9;
    public static final int MIN_MOVE_VALUE = 4;

    public static Random rand = new Random();

    public static Car[] prepareCar(int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car(0);
        }
        return cars;
    }

    public static void moveCars(Car[] cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    public static void moveCar(Car car) {
        if (canMove(rand.nextInt(MAX_RAND_VALUE))) {
            car.move();
        }
    }

    public static boolean canMove(int num) {
        return num >= MIN_MOVE_VALUE;
    }

}
