package racinggame;

import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.racing(tryNo);

        ResultView.printCars(racingGame.getCars());
        ResultView.printWinners(racingGame.getWinners());
    }
}
