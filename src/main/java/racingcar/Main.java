package racingcar;

import racingcar.controller.RacingGameConsole;
import racingcar.domain.SixtyPercentRandomDrivingStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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
