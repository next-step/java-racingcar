package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.domain.RacingGame;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.strategy.RandomDriveStrategy;
import camp.nextstep.edu.racingcar.view.RacingInputView;
import camp.nextstep.edu.racingcar.view.RacingOutputView;

public class Main {

    private static final RacingInputView input = new RacingInputView();
    private static final RacingOutputView output = new RacingOutputView();

    public static void main(String[] args) {
        DriveStrategy driveStrategy = new RandomDriveStrategy();
        int carAmount = inputCarAmount();
        int roundAmount = inputRoundAmount();

        RacingGame racingGame = new RacingGame(driveStrategy, carAmount, roundAmount);
        RacingGameResult gameResult = racingGame.play();
        output.printGameResult(gameResult);
    }

    private static int inputCarAmount() {
        output.printRequestCarAmount();
        return input.readCarAmount();
    }

    private static int inputRoundAmount() {
        output.printRequestRoundAmount();
        return input.readRoundAmount();
    }
}
