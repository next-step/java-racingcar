package racingCar.game;

import java.util.List;

public class RacingGameRequest {
	private final List<String> carNames;
	private final int tryCount;

	public RacingGameRequest(List<String> carNames, int tryCount) {
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	public int tryCount() {
		return tryCount;
	}

	public List<String> carNames() {
		return carNames;
	}
}
