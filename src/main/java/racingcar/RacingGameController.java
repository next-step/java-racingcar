package racingcar;

import racingcar.domain.game.GameInfo;
import racingcar.domain.game.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int totalGameCont = InputView.getTotalGameCont();

        RacingGame racingGame = new RacingGame(carCount, totalGameCont);
        while (!racingGame.isEndGame()) {
            racingGame.startRacing();
            ResultView.printResult(racingGame.getCars());
        }
    }
}
