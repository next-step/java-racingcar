package step4.service;

import step4.domain.car.CarList;
import step4.domain.view.UserInput;

public final class RacingGame {
	public static CarList race(UserInput userInput) {
		CarList cars = CarList.from(userInput.getNameList());
		for (int i = 0; i < userInput.getMoveCount(); i++) {
			cars.moveCarList();
		}
		return cars;
	}
}
