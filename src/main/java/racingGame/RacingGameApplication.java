package racingGame;

import racingGame.game.GameResult;
import racingGame.game.RacingGame;
import racingGame.game.RandomStrategy;
import racingGame.participant.Participants;
import racingGame.view.InputView;
import racingGame.view.RacingGameRequestDto;
import racingGame.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.execute();

        RacingGameRequestDto request = inputView.getRequest();
        RacingGame racingGame = new RacingGame(request.getParticipates(), request.getRound());
        GameResult gameResult = racingGame.start(new RandomStrategy());

        ResultView resultView = new ResultView(gameResult);
        resultView.print();
    }
}
