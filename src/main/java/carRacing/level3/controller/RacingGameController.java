package carRacing.level3.controller;

import carRacing.level3.service.MovingStrategy;
import carRacing.level3.service.input.InputView;
import carRacing.level3.service.CarService;

public class RacingGameController {

	CarService carService = new CarService();
	InputView inputView = new InputView();

	public void gameStart(MovingStrategy strategy) {

		int totalCarNum = inputView.askNumberCars();
		int gameRound = inputView.askValueRound();
		carService.moveCar(gameRound,carService.prepare(totalCarNum),strategy);

	}

}
