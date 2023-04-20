package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carNumber = InputView.receiveCarNumber(scanner);
        int cycleNumber = InputView.receiveTryNumber(scanner);

        Racing racing = new Racing();
        List<Car> cars = RacingManager.makeCars(carNumber);
        racing.runRacing(cars, cycleNumber);
    }
}
