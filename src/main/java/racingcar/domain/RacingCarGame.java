package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.Result;

public class RacingCarGame {
	private final Cars cars;
	private final int playCount;
	private List<Result> results;

	public RacingCarGame(Cars cars, int playCount) {
		this.cars = cars;
		this.playCount = playCount;
		results = new ArrayList<>();
	}

	public void start(MovingRule movingRule) {
		for (int i = 0; i < playCount; i++) {
			cars.play(movingRule);
			results.add(new Result(cars));
		}
	}

	public List<Result> getResults() {
		return results;
	}
}
