package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getRacingCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
