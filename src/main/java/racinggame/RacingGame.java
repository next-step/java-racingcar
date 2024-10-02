package racinggame;

import racinggame.racingcar.RandomMoveStrategy;
import racinggame.racingcar.MoveStrategy;

public class RacingGame {
    public static void main(String[] args) {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleResultView consoleResultView = new ConsoleResultView();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingGameController racingGameController = new RacingGameController(consoleInputView, consoleResultView, moveStrategy);

        racingGameController.run();
    }
}
