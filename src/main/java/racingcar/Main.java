package racingcar;

import racingcar.domain.GameResult;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String args[]) {
        InputView input = InputView.create();

        int carCount = input.getCarCount();
        int moveCount = input.getMoveCount();

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.createCars(carCount);

        OutputView.printMessage();

        for (int i = 0; i < moveCount; i++) {
            GameResult result = racingCarGame.execute();
            OutputView.printOut(result);
        }
    }
}
