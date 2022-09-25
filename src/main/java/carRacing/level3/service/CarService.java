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

	public Integer carMovingLocation(int carNum) {
		return carFactory.carLocation(carNum);
	}

	public void initRace(int carNum) {
		carFactory.initCarLocation(carNum);
	}

	public void moveCar(int carNum) {

		Boolean movable = isMovable(RandomNum.randomNum());

		int new_status = carFactory.moveCarLocation(carNum);

		if (movable) {
			carFactory.saveCarLocation(carNum, new_status);
		}
	}
}
