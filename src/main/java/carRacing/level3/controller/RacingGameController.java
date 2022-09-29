package carRacing.level3.controller;

import carRacing.level3.service.RandomMovingStartegy;
import carRacing.level3.service.input.InputView;
import carRacing.level3.service.CarService;

public class RacingGameController {

	CarService carService = new CarService();
	InputView inputView = new InputView();

	public void gameStart(RandomMovingStartegy randomMovingStartegy) {

		int carSum = inputView.askNumberCars();
		int carRound = inputView.askValueRound();
		carService.moveCar(carRound,carService.prepare(carSum),randomMovingStartegy);

	}

}
