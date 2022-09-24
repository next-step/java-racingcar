package carRacing.level3.service;

import carRacing.level3.repository.CarFactory;

public class CarService {
	private static final Integer BOUNDARY = 10;
	private static final Integer PIVOT = 4;

	CarFactory carFactory = new CarFactory();

	public Boolean isMovable(int randomNum) {
		if (randomNum >= PIVOT && randomNum < BOUNDARY) {
			return true;
		}
		return false;
	}

	public Integer carStatus(int carNum) {
		return carFactory.carStatus(carNum);
	}

	public void initRace(int carNum) {
		carFactory.initStatus(carNum);
	}

	public void moveCar(int carNum) {

		Boolean movable = isMovable(RandomNum.randomNum());

		int new_status = carFactory.updateStatus(carNum);

		if (movable) {
			carFactory.saveStatus(carNum, new_status);
		}
	}
}
