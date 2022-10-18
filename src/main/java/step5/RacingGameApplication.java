package step5;

import step5.controller.RacingGameController;
import step5.strategy.RandomMoveStrategy;
import step5.view.input.InputView;
import step5.view.input.InputViewImpl;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        RacingGameController controller = new RacingGameController(inputView.inputParticipant(), inputView.inputTryCnt(), new RandomMoveStrategy());
        controller.racingGame();
    }
}
