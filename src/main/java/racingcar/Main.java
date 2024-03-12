package racingcar;

import racingcar.domain.SixtyPercentRandomDrivingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.RacingGameConsole;

public class Main {

    public static void main(String[] args) {
        RacingGameConsole racingGameConsole = new RacingGameConsole(
            new InputView(),
            new OutputView(),
            new SixtyPercentRandomDrivingStrategy()
        );
        racingGameConsole.start();
    }
}
