package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.CarStatus;
import racingcar.domain.Game;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;


public class RacingCarRunner {

    public static void main(String[] args) {
        List<CarName> carNames = Input.processCarNames();
        int tryCount = Input.processTryCount();
        Game game = new Game(carNames, tryCount);

        List<CarStatus> initialStatus = game.getCars().mapToStatus();
        List<List<CarStatus>> gameStatus = game.run();
        List<CarName> winners = game.findWinnerNames();

        Output.printInitialStatus(initialStatus);
        Output.printGameStatus(gameStatus);
        Output.printWinners(winners);
    }
}
