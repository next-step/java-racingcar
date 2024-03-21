package racing;

import java.util.ArrayList;
import java.util.List;

import static racing.InputView.inputCarCount;
import static racing.InputView.inputTryCount;
import static racing.ResultView.printResult;
import static racing.ResultView.printResultMessage;

public class RacingMain {
    public static void main(String[] args) {
        int carCount = inputCarCount();
        int tryCount = inputTryCount();
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }

        printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            printResult(cars);
            System.out.println();
            carMove(cars);
        }
    }



    private static void carMove(List<Car> cars) {
        for (Car  car : cars) {
            car.move();
        }
    }
}
