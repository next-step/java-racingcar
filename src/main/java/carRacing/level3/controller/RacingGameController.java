package carRacing.level3.controller;

import carRacing.level3.model.Cars;
import carRacing.level3.model.Winner;
import carRacing.level3.model.strategy.MovingStrategy;
import carRacing.level3.view.input.InputView;
import carRacing.level3.view.output.OutPutView;
import java.util.List;

public class RacingGameController {

	private InputView inputView = new InputView();
	private OutPutView outPutView = new OutPutView();
	private Winner winner = new Winner();

	public void gameStart(MovingStrategy movingStrategy) {

		List<String> carNameList = inputView.saveCarNames();
		int gameRound = inputView.askValueRound();

		Cars cars = Cars.create(carNameList);

		outPutView.showNotice();

		for (int i = 0; i < gameRound; i++) {
			cars.moveCarLocation(movingStrategy);
			outPutView.showRace(cars);
		}

		winner.decideWinner(cars);
		outPutView.showWinner(winner.getWinnerList());

	}

}
