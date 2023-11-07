package racingcar.controller;

import racingcar.domain.game.RacingGame;
import racingcar.domain.game.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int totalGameCont = InputView.getTotalGameCont();

        RacingGame racingGame = new RacingGame(carCount, totalGameCont);
        while (!racingGame.isEndGame()) {
            racingGame.startRacing(new RandomMoveStrategy());
            ResultView.printResult(racingGame.getCars());
        }
    }
}
