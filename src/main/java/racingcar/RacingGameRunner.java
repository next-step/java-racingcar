package racingcar;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        RacingGameOption option = InputView.inputRacingGameOption();

        RacingGame racingGame = new RacingGame(option);
        List<RacingGameResultSet> racingGameResultSets = racingGame.start();

        ResultView.showRacingGameResult(racingGameResultSets);
    }
}
