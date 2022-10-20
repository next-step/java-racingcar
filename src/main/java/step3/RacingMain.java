package step3;

import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(carCount, tryCount);
        while (racingGame.racing()) {
            racingGame.race();
            ResultView.print(racingGame.getCars());
        }
    }
}
