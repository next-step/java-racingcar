package step4.controller;

import step4.model.Cars;
import step4.model.Winners;
import step4.view.output.OutputView;
import step4.view.output.OutputViewImpl;

public class RacingGameController {
	private static final Cars CARS = new Cars();
	private static final Winners WINNERS = new Winners();
	private static final OutputView OUTPUT_VIEW = new OutputViewImpl();

	public void racingGame(String nameListString, int trys) {
		CARS.init(nameListString);
		for (int i = 0; i < trys; i++) {
			CARS.getCars().forEach(car -> car.move());
			OUTPUT_VIEW.printRacingResult(CARS);
		}
		WINNERS.checkWinners(CARS, WINNERS.getWinnerStandard(CARS));
		OUTPUT_VIEW.printWinner(WINNERS);
	}
}
