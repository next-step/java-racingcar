package step3;

import step3.domain.RacingGame;
import step3.domain.RandomMoveRule;
import step3.view.InputView;
import step3.view.ResultView;

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
        resultView.printResult(racingGame.getCars(), racingGame.getRoundTime());

        racingGame.end();
    }
}
