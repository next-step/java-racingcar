package racing.controller;

import racing.dto.GameRequest;
import racing.model.MoveStrategy;
import racing.model.Racing;
import racing.model.RandomNumber;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {

	private static final MoveStrategy moveStrategy = new MoveStrategy(new RandomNumber());

	public void run() {
		GameRequest gameRequest = InputView.inputGameRequest();
		playGame(gameRequest.getTimes(), new Racing(gameRequest.getNames()));
	}

	private void playGame(int times, Racing racing) {
		OutputView.printResultMessage();
		for (int i = 0; i < times; i++) {
			OutputView.printResults(racing.race(moveStrategy));
		}
		OutputView.printWinners(racing.getWinners());
	}
}
