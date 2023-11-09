package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.domain.RacingGame;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.strategy.RandomDriveStrategy;
import camp.nextstep.edu.racingcar.view.RacingInputView;
import camp.nextstep.edu.racingcar.view.RacingOutputView;

public class Main {

    public static void main(String[] args) {
        DriveStrategy driveStrategy = new RandomDriveStrategy();
        int carAmount = inputCarAmount();
        int roundAmount = inputRoundAmount();

        RacingGame racingGame = new RacingGame(driveStrategy, carAmount, roundAmount);
        RacingGameResult gameResult = racingGame.play();

        RacingOutputView.printGameResult(gameResult);
    }

    private static int inputCarAmount() {
        return RacingInputView.readCarAmount();
    }

    private static int inputRoundAmount() {
        return RacingInputView.readRoundAmount();
    }
}
