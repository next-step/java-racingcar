package step4;

import step4.controller.RacingGameController;
import step4.strategy.RandomMoveStrategy;
import step4.view.input.InputView;
import step4.view.input.InputViewImpl;

public class RacingGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        RacingGameController controller = new RacingGameController(inputView.inputParticipant(), inputView.inputTryCnt(), new RandomMoveStrategy());
        controller.racingGame();
    }
}
