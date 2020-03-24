package step3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.printCarNameListInfo();
        String[] carNameList = inputView.readInputString();

        inputView.printRoundTimeInfo();
        int roundTime = inputView.readInputInt();

        RacingGame racingGame = new RacingGame(roundTime, carNameList);
        racingGame.setMoveRule(new RandomMoveRule());
        racingGame.start();

        ResultView resultView = new ResultView();
        resultView.printResultInfo();
        resultView.printResult(racingGame);

        racingGame.end();
    }
}
