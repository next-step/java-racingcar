package racingcar;

import java.util.Arrays;

public class RacingCars {

    private static final int MINIMUM_VALUE = 4;
    private final Car[] cars;

    private RacingCars(int number) {
        validateNumber(number);
        this.cars = new Car[number];
        for (int i = 0; i < number; i++) {
            cars[i] = Car.from();
        }
    }

    public static RacingCars create(int number) {
        return new RacingCars(number);
    }

    private static void validateNumber(int number) {
        if (number < 0) {
            throw new RacingCarException(RacingCarErrorCode.CAR_NUMBER_BAD_REQUEST);
        }
    }

    public void moving() {
        for (Car car : cars) {
            if (isValidNumber(RandomNumberGenerator.getRandomNumber())) {
                car.moveForward();
            }
        }
    }

    private boolean isValidNumber(int number) {
        return number >= MINIMUM_VALUE;
    }

    public void print() {
        for (Car car : cars) {
            RacingCarView.printRacingCar(car);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Arrays.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cars);
    }
}
