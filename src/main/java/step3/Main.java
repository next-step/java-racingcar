package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarCountInfo();
        int carCount = inputView.readInputInt();

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInputInt();

        GameRule gameRule = new GameRule();

        RacingGame racingGame = new RacingGame(carCount, roundTime, gameRule);
        racingGame.start();

        ResultView resultView = new ResultView();
        resultView.printResultInfo();
        resultView.printResult(racingGame);

        racingGame.end();
    }
}
