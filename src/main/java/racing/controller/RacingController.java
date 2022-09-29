package racing.controller;

import racing.model.MoveStrategy;
import racing.model.Racing;
import racing.view.GameRequest;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {

	private static final MoveStrategy moveStrategy = new MoveStrategy();

	public void run() {
		GameRequest gameRequest = InputView.inputGameRequest();
		playGame(gameRequest.getTimes(), new Racing(gameRequest.getNames()));
	}

	private void playGame(int times, Racing racing) {
		OutputView.printResultMessage();
		for (int i = 0; i < times; i++) {
			OutputView.printResult(racing.race(moveStrategy));
		}
	}
}
