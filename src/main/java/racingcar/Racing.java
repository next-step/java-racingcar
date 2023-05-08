package racingcar;

import java.util.ArrayList;
import java.util.List;

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
            car.move(new MoveStrategy());
        }
    }

    private static List<Car> createRacingCars(int number) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(Car.create());
        }
        return cars;
    }
}
