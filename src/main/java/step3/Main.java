package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarCountInfo();
        int carCount = inputView.readInput();
        ValidationUtils.validateCarCount(carCount);

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInput();
        ValidationUtils.validateRoundTime(roundTime);

        RacingGame racingGame = new RacingGame();
        racingGame.play(carCount, roundTime);

        ResultView resultView = new ResultView();

        resultView.printResult();
    }
}
