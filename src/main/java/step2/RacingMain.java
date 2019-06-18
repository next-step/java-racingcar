package step2;

import java.util.List;

public class RacingMain {

    public static void main(String[] arg) {
        int inputCarNumber = InputView.inputCarNumber();
        int inputExecuteNumber = InputView.inputExecuteNumber();
        RacingGame racingGame = new RacingGame(inputCarNumber);

        while (inputExecuteNumber > 0) {
            List<Car> carPositions = racingGame.move();
            OutputView.racingResult(carPositions);
            inputExecuteNumber--;
        }
    }

}
