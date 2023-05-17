package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int tryAmount = InputView.getTryAmount();
        Cars cars = new Cars(carNames);

        Game game = new Game(cars);
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            game.play();
            OutputView.printCarPosition(cars);
        }
        OutputView.printWinner(game.getWinner());
    }
}
