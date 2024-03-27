package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.Car.findWinners;
import static racing.InputView.inputCarNames;
import static racing.InputView.inputTryCount;
import static racing.ResultView.*;

public class RacingMain {
    public static void main(String[] args) {

        String[] names = inputCarNames().split(",");
        int tryCount = inputTryCount();
        List<Car> cars = getCars(names);

        printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            carMove(cars);
            printResult(cars);
        }

        printWinners(findWinners(cars));
    }

    private static List<Car> getCars(String[] names) {
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
