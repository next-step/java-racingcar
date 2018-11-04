package racingcar;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGameOption option = inputView.inputRacingGameOption();

        RacingGame racingGame = new RacingGame(option);
        List<RacingGameResultSet> resultSets = racingGame.start();

        ResultView resultView =  new ResultView();
        resultView.showRacingGameResults(resultSets);
    }
}
