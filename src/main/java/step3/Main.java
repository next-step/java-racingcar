package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarNameListInfo();
        String[] carNameList = inputView.readInputString();

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInputInt();

        GameRule gameRule = new GameRule();

        RacingGame racingGame = new RacingGame(roundTime, gameRule, carNameList);
        racingGame.start();

        ResultView resultView = new ResultView();
        resultView.printResultInfo();
        resultView.printResult(racingGame);

        racingGame.end();
    }
}
