package racingcar.domain;

import racingcar.view.Result;
import racingcar.view.Results;

public class CountOfGamePlay {
	private final int playCount;

	public CountOfGamePlay(int playCount) {
		this.playCount = playCount;
	}

	public Results run(Cars cars, RandomGenerator randomGenerator) {
		Results results = new Results();
		for (int i = 0; i < playCount; i++) {
			cars.play(randomGenerator);
			results.add(cars.result());
		}
		return results;
	}
}
