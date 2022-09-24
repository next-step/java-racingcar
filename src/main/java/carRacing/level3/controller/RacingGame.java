package carRacing.level3.controller;

import carRacing.level3.output.OutPutView;
import carRacing.level3.service.CarService;

public class RacingGame {

	CarService carService = new CarService();
	OutPutView outPutView = new OutPutView();

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
