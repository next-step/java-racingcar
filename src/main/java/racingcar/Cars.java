package racingcar;

import java.util.Random;

public class Cars {
    private final Car[] cars;
    private final Random random = new Random();

    private Cars(int number) {
        this.cars = new Car[number];
        for (int i = 0; i < number; i++) {
            cars[i] = Car.from();
        }
    }

    public static Cars create(int number) {
        validateNumber(number);
        return new Cars(number);
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("정수값만 입력가능합니다.");
        }
    }

    public void moving() {
        for (int i = 0; i < cars.length; i++) {
            if (isValidNumber(getRandomNumber())) {
                cars[i].moveForward();
            }
        }
    }

    private boolean isValidNumber(int number) {
        return number >= 4;
    }

    private int getRandomNumber() {
        return random.nextInt(10);
    }

    public void print() {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getLocation()));
        }
    }
}
