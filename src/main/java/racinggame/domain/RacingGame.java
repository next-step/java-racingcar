package racinggame.domain;

import racinggame.dto.GameResultDto;

public class RacingGame {
	public GameResultDto start(String carNames, int moveCount) {
		Cars cars = new Cars();
		cars.createCarsWithCarNames(carNames);
		return cars.startRacing(moveCount);
	}
}
