package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    public static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int racingCount = InputView.getRacingCount();
        run(carCount, racingCount);
    }

    private static void run(int carCount, int racingCount) {
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }

        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                Movement movement = new Movement(new Random());
                car.move(movement.isMove());
            }
            ResultView.printResult();
        }
    }
}
