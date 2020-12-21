package racinggame.domain;

import racinggame.dto.GameResultDto;

public class RacingGame {
	public GameResultDto start(String carNames, int moveCount) {
		String[] carNamesArray = carNames.split(",");
		Cars cars = new Cars(carNamesArray);
		return cars.startRacing(moveCount);
	}
}
