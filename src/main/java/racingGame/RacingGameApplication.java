package racingGame;

import racingGame.game.GameResult;
import racingGame.game.RacingGame;
import racingGame.game.RandomStrategy;
import racingGame.participant.Participants;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        Participants participants = new Participants(inputView.getParticipates());
        int gameCount = inputView.getGameCount();
        RacingGame racingGame = new RacingGame(new RandomStrategy());
        racingGame.participate(participants, gameCount);
        GameResult gameResult = racingGame.start();

        ResultView resultView = new ResultView(gameResult);
        resultView.print();
    }
}
