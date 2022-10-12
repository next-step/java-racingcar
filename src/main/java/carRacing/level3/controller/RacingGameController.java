package carRacing.level3.controller;

import carRacing.level3.model.Cars;
import carRacing.level3.model.Winner;
import carRacing.level3.model.strategy.MovingStrategy;
import carRacing.level3.view.input.InputView;
import carRacing.level3.view.output.OutPutView;
import java.util.List;

public class RacingGameController {

	private final static InputView INPUT_VIEW = new InputView();
	private final static OutPutView OUT_PUT_VIEW = new OutPutView();


	public void gameStart(MovingStrategy movingStrategy) {

		List<String> carNameList = INPUT_VIEW.saveCarNames();
		int gameRound = INPUT_VIEW.askValueRound();

		Cars cars = Cars.create(carNameList);

		OUT_PUT_VIEW.showNotice();

		for (int i = 0; i < gameRound; i++) {
			cars.moveCarLocation(movingStrategy);
			OUT_PUT_VIEW.showRace(cars);
		}

		Winner winner = new Winner(cars);

		OUT_PUT_VIEW.showWinner(winner.findWinner());

	}

}
