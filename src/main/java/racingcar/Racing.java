package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {

    public static void main(String[] args) {
        final int number = InputView.getCarCount();
        List<Car> cars = createRacingCars(number);

        final int tryCount = InputView.getTryCount();
        racing(cars, tryCount);
    }

    private static void racing(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveRacingCars(cars);
            ResultView.racingView(cars);
        }
    }

    private static void moveRacingCars(List<Car> cars) {
        for (final Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private static List<Car> createRacingCars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(Car.create());
        }
        return cars;
    }

    public static boolean canMove() {
        Random random = new Random();
        final int i = random.nextInt(10);

        return i >= 4;
    }
}
