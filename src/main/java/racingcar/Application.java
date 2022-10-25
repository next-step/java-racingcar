package racingcar;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final String carNames = InputView.getCarNames();
        final String tryNo = InputView.getTryNo();

        final Game game = new Game(carNames, tryNo);
        OutputView.printDivider();
        OutputView.printGameResultTitle();
        while (!game.isGameOver()) {
            game.play();
            OutputView.printCarStatuses(game.getCarStatuses());
            OutputView.printDivider();
        }
        OutputView.printWinners(game.getWinners());
    }

}
