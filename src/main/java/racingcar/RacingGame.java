package racingcar;

import racingcar.domain.Racing;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Random;

import static racingcar.application.CarConstant.INPUT_CAR_NAME_MESSAGE;
import static racingcar.application.CarConstant.INPUT_CAR_TRY_COUNT_MESSAGE;

public class RacingGame {

    public static void main(String[] args) {

        String[] carNames = InputView.nextLineWithSplit(INPUT_CAR_NAME_MESSAGE, ",");
        int tryCount = InputView.nextInt(INPUT_CAR_TRY_COUNT_MESSAGE);
        MovingStrategy movingStrategy = new RandomMovingStrategy(new Random(System.currentTimeMillis()));

        try {
            Racing racing = new Racing(carNames, tryCount, movingStrategy);
            racing.start();
        } catch (IllegalArgumentException exception) {
            OutputView.print(exception.getMessage());
        }

    }
}
