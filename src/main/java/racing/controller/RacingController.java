package racing.controller;

import racing.model.MoveStrategy;
import racing.model.Racing;
import racing.view.GameRequestDto;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingController {

	private static final MoveStrategy moveStrategy = new MoveStrategy();

	public void run() {
		GameRequestDto gameRequestDto = InputView.inputGameRequest();
		playGame(gameRequestDto.getTimes(), new Racing(gameRequestDto.getCarCount()));
	}

	private void playGame(int times, Racing racing) {
		OutputView.printResultMessage();
		for (int i = 0; i < times; i++) {
			racing.race(moveStrategy);
			OutputView.printCarsPosition(racing.getCars());
		}
	}
}
