package racingcar;

import racingcar.domain.CarName;
import racingcar.domain.CarStatus;
import racingcar.domain.Game;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;


public class RacingCarRunner {

    public static void main(String[] args) {
        List<CarName> carNames = InputView.processCarNames();
        TryCount tryCount = InputView.processTryCount();
        Game game = new Game(carNames, tryCount);

        List<CarStatus> initialStatus = game.getCars().mapToStatus();
        List<List<CarStatus>> gameStatus = game.run();
        List<CarName> winners = game.findWinnerNames();

        OutputView.printInitialStatus(initialStatus);
        OutputView.printGameStatus(gameStatus);
        OutputView.printWinners(winners);
    }
}
