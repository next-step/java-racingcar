package carRacing.level3.controller;

import carRacing.level3.service.input.InputView;
import carRacing.level3.service.output.OutPutView;
import carRacing.level3.service.CarService;

public class RacingGame {

	public static final Integer INIT_ROUND = 1;

	CarService carService = new CarService();
	OutPutView outPutView = new OutPutView();
	InputView inputView = new InputView();

	public void gameStart() {

		int carSum = inputView.askNumberCars();
		int carRound = inputView.askValueRound();

		initRace(carSum);

		for (int i = 0; i < carRound - INIT_ROUND; i++) {
			driveCar(carSum);
			printSpace();
		}

	}

	public void initRace(int carSum) {
		for (int car = 0; car < carSum; car++) {
			carService.initRace(car);
			showRace(car);
		}
		printSpace();
	}

	public void driveCar(int carSum) {
		for (int car = 0; car < carSum; car++) {
			carService.moveCar(car);
			showRace(car);
		}
	}

	public void showRace(int carNum) {
		outPutView.showCar(carService.carStatus(carNum));
	}

	public void printSpace() {
		outPutView.printSpace();
	}

}
