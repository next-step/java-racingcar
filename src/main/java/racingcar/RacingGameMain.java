package racingcar;

import racingcar.domain.PlayCount;
import racingcar.domain.RacingGame;
import racingcar.util.InputView;
import racingcar.util.ResultView;

public class RacingGameMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] participants = inputView.participantApplication();
        RacingGame racingGame = new RacingGame(participants);

        PlayCount playCount = new PlayCount(inputView.playCount());

        ResultView resultView = new ResultView();
        resultView.start();

        for (int i = 0; i < playCount.getCount(); i++) {
            racingGame.race();
            resultView.score(racingGame.score());
        }
        resultView.winner(racingGame.winner());
    }
}
