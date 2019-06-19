package racing;

import racing.io.InputView;
import racing.io.OutputView;
import racing.model.Car;
import racing.model.RacingGame;

import java.util.List;

public class RacingApplication {

    public static void main(String[] args) {
        List<Car> cars = InputView.createCarsByNames();
        int raceCount = InputView.getRaceCount();
        RacingGame racingGame = RacingGame.of(cars);
        for (; raceCount != 0; raceCount--) {
            racingGame.run();
            OutputView.view(racingGame.getCars());
        }
        OutputView.showWinner(racingGame.getCars());
    }
}
