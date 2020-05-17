package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView input = InputView.create();

        int carCount = input.getCarCount();
        int moveCount = input.getMoveCount();

        OutputView.printMessage();

        RacingCarGame racingCarGame = new RacingCarGame(carCount, moveCount);
        racingCarGame.execute(new RandomStrategy());
    }
}
