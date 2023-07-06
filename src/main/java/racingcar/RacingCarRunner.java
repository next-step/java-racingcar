package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.Game;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;


public class RacingCarRunner {

    public static void main(String[] args) {
        List<CarName> carNames = Input.processCarNames();
        int tryCount = Input.processTryCount();
        Game game = new Game(carNames);

        Output.printInitialStatus(game.getCars());
        runGame(game, tryCount);
        Output.printWinners(game.findWinnerNames());
    }

    private static void runGame(Game game, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            game.run();
            Output.printCarStatus(game.getCars());
        }
    }
}
