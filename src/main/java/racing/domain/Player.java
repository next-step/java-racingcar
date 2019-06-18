package racing.domain;

import racing.domain.accelerator.DriveAccelerator;


public class Player {

	private DriveAccelerator accelerator;

	private RacingCar car;

	public Player(DriveAccelerator accelerator, RacingCar car) {

		this.car = car;
		this.accelerator = accelerator;
	}

	public int drive() {

		this.car.move(accelerator.getAmount());

		return car.getMileage();
	}
}
