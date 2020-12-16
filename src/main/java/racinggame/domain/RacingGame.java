package racinggame.domain;

import racinggame.dto.GameResultDto;

public class RacingGame {
	private GameResultDto gameResultDto;

	public GameResultDto getGameResultDto() {
		return gameResultDto;
	}

	public void start(String carNames, int moveCount) {
		Cars cars = new Cars(carNames);
		gameResultDto = cars.startRacing(moveCount);
	}
}
