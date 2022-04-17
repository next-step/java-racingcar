package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.view.Result;
import racingcar.view.Results;

public class RacingCarGame {
	private final Cars cars;
	private final int playCount;

	public RacingCarGame(Cars cars, int playCount) {
		this.cars = cars;
		this.playCount = playCount;
	}

	public Results start(RandomGenerator randomGenerator) {
		Results results = new Results();
		for (int i = 0; i < playCount; i++) {
			cars.play(randomGenerator);
			results.add(cars.result());
		}
		return results;
	}
}
