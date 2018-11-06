package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.InputView;
import racingcar.domain.Racing;
import racingcar.domain.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String cars = InputView.inputCars();
        int tryTime = InputView.inputTryTime();

        Racing racing = new Racing(cars);
        GameResult result;

        for(int i = 0; i < tryTime; i++) {
            racing.moveCars();
            ResultView.printCars(racing.getRacingCars());
            System.out.println();

        }

        result = new GameResult(racing.getRacingCars());
        ResultView.printWinners(result);
    }
}
