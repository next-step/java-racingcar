package step5.controller;

import step5.domain.RacingGame;
import step5.strategy.ProdMove;
import step5.view.InputView;
import step5.view.ResultView;

public class GameStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame racingGame = new RacingGame(inputView.inputCarNames(), new ProdMove());
        int playCount = inputView.inputPlayCount();

        ResultView resultView = new ResultView();
        for (int i = 0; i < playCount; i++) {
            racingGame.play();
            resultView.showResult(racingGame.getRacingCars());
        }
        resultView.showWinner(racingGame.getRacingCars().getWinCarNames());
    }
}
