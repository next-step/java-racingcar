package racingcar;

import java.util.List;
import java.util.Scanner;

public class RacingCarApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerGroup = InputView.receiveCarNumber(scanner);
        int cycleNumber = InputView.receiveTryNumber(scanner);

        List<Car> cars = RacingManager.makeCars(playerGroup);
        Racing racing = new Racing();
        racing.runRacing(cars, cycleNumber);

        List<String> winnerNames = RacingManager.extractWinnerNames(cars);
        OutputView.printWinnerNames(winnerNames);
    }
}
