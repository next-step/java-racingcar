package racingcar.v2;

import racingcar.v2.domain.RacingGame;
import racingcar.v2.view.InputView;
import racingcar.v2.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        RacingGame racingGame = new RacingGame(carNames, tryNumber);

        ResultView.printHead();
        while (racingGame.racing()) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }

        ResultView.printWinners(racingGame.getWinners());
    }
}
