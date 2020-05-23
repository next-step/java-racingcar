package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView input = InputView.create();

        String carNames = input.getCarNames();
        int moveCount = input.getMoveCount();

        OutputView.printMessage();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, moveCount);
        racingCarGame.execute(new RandomStrategy());

        OutputView.printOutResult(racingCarGame.getCarsList());
        OutputView.printOutWinner(racingCarGame.getWinners());
    }
}
