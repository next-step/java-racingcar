package racingcar;

import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final String carNo = InputView.getCarNo();
        final String tryNo = InputView.getTryNo();
        final Game game = new Game(carNo, tryNo);
        OutputView.printDivider();
        OutputView.printGameResultTitle();
        while (!game.isGameOver()) {
            game.play();
            OutputView.printCarDistances(game.getCarDistances());
            OutputView.printDivider();
        }
    }

}
