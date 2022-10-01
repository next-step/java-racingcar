package step4;

import step4.controller.RacingGameController;
import step4.view.input.InputView;
import step4.view.input.InputViewImpl;

public class RacingGameApplication {
	public static void main(String[] args) {
		RacingGameController controller = new RacingGameController();
		InputView inputView = new InputViewImpl();
		controller.racingGame(inputView.inputParticipant(), inputView.inputTryCnt());
	}
}
