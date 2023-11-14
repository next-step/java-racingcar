package racingCar.game;

import java.util.List;

public class GameRequest {
	private List<String> carNameList;
	private int carCount;
	private final int tryCount;

	public GameRequest(int carCount, int tryCount) {
		this.carCount = carCount;
		this.tryCount = tryCount;
	}

	public GameRequest(String carNames, int tryCount) {
		this.carNameList = List.of(carNames.split(","));
		this.tryCount = tryCount;
	}

	public int carCount() {
		return carCount;
	}

	public List<String> carNameList() {
		return carNameList;
	}

	public int tryCount() {
		return tryCount;
	}
}
