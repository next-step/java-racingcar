package racingcar.controller;

import racingcar.domain.game.RacingGame;
import racingcar.domain.game.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        String inputCarName = InputView.getCarCount();
        int totalGameCont = InputView.getTotalGameCont();

        RacingGame racingGame = new RacingGame(inputCarName, totalGameCont);
        while (!racingGame.isEndGame()) {
            racingGame.startRacing(new RandomMoveStrategy());
            ResultView.printRacing(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
