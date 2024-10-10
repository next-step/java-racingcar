package step4.service;

import step4.domain.car.CarList;
import step4.domain.racehistory.MovedHistory;
import step4.domain.racehistory.RacingHistory;
import step4.domain.view.UserInput;

public final class RacingGame {
	public static RacingHistory race(UserInput userInput) {
		CarList cars = CarList.from(userInput.getNameList());
		RacingHistory racingHistory = new RacingHistory();
		for (int i = 0; i < userInput.getMoveCount(); i++) {
			cars.moveCarList();
			MovedHistory movedHistory = MovedHistory.from(cars);
			racingHistory.writePositionHistory(movedHistory);
		}
		return racingHistory;
	}
}
