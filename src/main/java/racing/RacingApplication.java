package racing;

import racing.io.InputView;
import racing.io.OutputView;
import racing.model.CarFactory;
import racing.model.RacingGame;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.of(CarFactory.createCarsByNames(InputView.getCarNames()));
        int raceCount = InputView.getRaceCount();
        for (; raceCount != 0; raceCount--) {
            racingGame.run();
            OutputView.view(racingGame.getCars());
        }
        OutputView.showWinner(Winner.getNames(racingGame.getCars()));
    }
}
