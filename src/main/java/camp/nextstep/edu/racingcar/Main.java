package camp.nextstep.edu.racingcar;

import camp.nextstep.edu.racingcar.domain.RacingGame;
import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;
import camp.nextstep.edu.racingcar.domain.strategy.DriveStrategy;
import camp.nextstep.edu.racingcar.domain.strategy.RandomDriveStrategy;
import camp.nextstep.edu.racingcar.view.RacingInputView;
import camp.nextstep.edu.racingcar.view.RacingOutputView;

public class Main {

    public static final String DELIMITER = ",";

    public static void main(String[] args) {
        DriveStrategy driveStrategy = new RandomDriveStrategy();
        String carNames = RacingInputView.readCarNames();
        int roundAmount = RacingInputView.readRoundAmount();

        RacingGame racingGame = new RacingGame(driveStrategy, carNames.split(DELIMITER), roundAmount);
        RacingGameResult gameResult = racingGame.play();

        RacingOutputView.printGameResult(gameResult);
    }
}
