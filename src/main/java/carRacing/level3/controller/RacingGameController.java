package carRacing.level3.controller;

import carRacing.level3.model.Cars;
import carRacing.level3.model.strategy.MovingStrategy;
import carRacing.level3.model.strategy.WinnerStrategy;
import carRacing.level3.view.input.InputView;
import carRacing.level3.view.output.OutPutView;
import java.util.List;

public class RacingGameController {

	InputView inputView = new InputView();
	OutPutView outPutView = new OutPutView();

	public void gameStart(WinnerStrategy winnerStrategy, MovingStrategy movingStrategy)
		throws Exception {

		List<String> carNameList = inputView.saveCarNames();
		int gameRound = inputView.askValueRound();

		Cars cars = Cars.create(carNameList);

		for (int i = 0; i < gameRound; i++) {
			cars.moveCarLocation(movingStrategy);
			outPutView.showRace(cars);
		}

		outPutView.showWinner(winnerStrategy.winnerList(cars));

	}

}
