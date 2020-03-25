package racingGame;

import racingGame.game.CarForwardRule;
import racingGame.game.GameResult;
import racingGame.game.RacingGame;
import racingGame.game.RacingGameRule;
import racingGame.participant.Participants;
import racingGame.participant.ParticipantsV2;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        Participants participants = new ParticipantsV2(inputView.getParticipates());
        int gameCount = inputView.getGameCount();
        RacingGameRule gameRule = new CarForwardRule();
        RacingGame racingGame = new RacingGame(gameRule);

        racingGame.participate(participants, gameCount);
        GameResult gameResult = racingGame.start();

        ResultView resultView = new ResultView(gameResult);
        resultView.print();
    }
}
