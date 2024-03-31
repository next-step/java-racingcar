package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.domain.Car.findWinners;
import static racing.view.ResultView.printResult;
import static racing.view.ResultView.printWinners;

public class RacingGame {
    private final int tryCount;
    private final List<Car> cars;

    public RacingGame(int tryCount, List<Car> cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void race() {
        for (int i = 0; i < tryCount; i++) {
            carMove(cars);
            printResult(cars);
        }
        printWinners(findWinners(cars));
    }

    public static List<Car> getCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void carMove(List<Car> cars) {
        final int RANDOM_MAX = 10;
        Random random = new Random();

        for (Car  car : cars) {
            car.move(random.nextInt(RANDOM_MAX));
        }
    }
}
