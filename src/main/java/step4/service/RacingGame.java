package step4.service;

import step4.domain.car.CarList;
import step4.domain.racehistory.MovedHistory;
import step4.domain.racehistory.RacingHistory;
import step4.domain.view.UserInput;

public final class RacingGame {
	public static RacingHistory race(UserInput userInput) {
		CarList cars = makeCars(userInput);

		RacingHistory racingHistory = new RacingHistory();
		for (int i = 0; i < userInput.getMoveCount(); i++) {
			racingHistory.writePositionHistory(moveCars(cars));
		}
		return racingHistory;
	}

	public static CarList makeCars(UserInput userInput) {
		return CarList.from(userInput.getNameList());
	}

	private static MovedHistory moveCars(CarList cars) {
		cars.moveCarList();
		return MovedHistory.from(cars);
	}
}
