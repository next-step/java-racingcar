package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.InputView.inputCarNames;
import static racing.InputView.inputTryCount;
import static racing.ResultView.printResult;
import static racing.ResultView.printResultMessage;

public class RacingMain {
    public static void main(String[] args) {

        String carNames = inputCarNames();
        String[] names = carNames.split(",");
        int tryCount = inputTryCount();
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            printResult(cars);
            System.out.println();
            carMove(cars);
        }
    }

    private static void carMove(List<Car> cars) {
        final int RANDOM_MAX = 10;

        for (Car  car : cars) {
            car.move(new Random().nextInt(RANDOM_MAX));
        }
    }
}
