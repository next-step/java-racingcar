package racingcar;

import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.policy.MovePolicy;
import racingcar.domain.policy.ZeroToNineRandomMovePolicy;
import racingcar.domain.racinggame.TryNumber;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        MovePolicy movePolicy = new ZeroToNineRandomMovePolicy();

        RacingGame racingGame = new RacingGame(carNames, tryNumber, movePolicy);

        ResultView.printHead();
        racingGame.race();

        ResultView.printRacingGameResult(racingGame.getCars(), new TryNumber(tryNumber));
        ResultView.printWinners(racingGame.getWinners());
    }
}
