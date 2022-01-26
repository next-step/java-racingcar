package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.gettryNo();
        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (!racingGame.isEnd()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
