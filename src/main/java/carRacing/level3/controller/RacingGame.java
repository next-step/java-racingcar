package carRacing.level3.controller;

import carRacing.level3.service.CarService;

public class RacingGame {

	CarService carService = new CarService();

	public void initRace(int carSum) {
		for (int car = 0; car < carSum; car++) {
			carService.initRace(car);
		}
	}

}
