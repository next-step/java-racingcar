package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	private final int trials;
	private final Cars cars;

	public Racing(int trials, int cars) {
		this.trials = trials;
		this.cars = new Cars(cars);
	}

	public List<RacingResult> race() {
		List<RacingResult> result = new ArrayList<>();

		for (int i = 0; i < trials; i++) {
			cars.raceOneTrial();
			List<Integer> resultOneTrial = cars.getResultOneTrial();
			RacingResult racingResult = new RacingResult(trials, resultOneTrial);
			result.add(racingResult);
		}

		return result;
	}
}
