package racingcar;

import java.util.Random;

public class RacingCars {
    private final Car[] cars;
    private final static int MINIMUM_VALUE = 4;
    private final static int MAXIMUM_VALUE = 10;
    private final static String LOCATION_PRINT_LETTER = "-";
    private final Random random = new Random();

    private RacingCars(int number) {
        this.cars = new Car[number];
        for (int i = 0; i < number; i++) {
            cars[i] = Car.from();
        }
    }

    public static RacingCars create(int number) {
        validateNumber(number);
        return new RacingCars(number);
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("정수값만 입력가능합니다.");
        }
    }

    public void moving() {
        for (Car car : cars) {
            if (isValidNumber(getRandomNumber())) {
                car.moveForward();
            }
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MINIMUM_VALUE;
    }

    private int getRandomNumber() {
        return random.nextInt(MAXIMUM_VALUE);
    }

    public void print() {
        for (Car car : cars) {
            System.out.println(LOCATION_PRINT_LETTER.repeat(car.getLocation()));
        }
    }
}
