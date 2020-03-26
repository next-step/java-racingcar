package racingGame.controller;

import racingGame.domain.game.GameResult;
import racingGame.domain.game.RacingGame;
import racingGame.domain.game.RandomStrategy;
import racingGame.view.InputView;
import racingGame.view.RacingGameRequestDto;
import racingGame.view.ResultView;

public class RacingGameController {

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
