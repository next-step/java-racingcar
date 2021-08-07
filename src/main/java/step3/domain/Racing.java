package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	private final int trials;
	private final Cars cars;

	public Racing(int trials, String[] cars) {
		this.trials = trials;
		this.cars = new Cars(cars);
	}

	public List<RacingResults> race() {
		List<RacingResults> results = new ArrayList<>();

		for (int i = 0; i < trials; i++) {
			cars.raceOneTrial();
			List<Car> resultOneTrial = cars.getResultOneTrial();
			RacingResults result = new RacingResults(resultOneTrial);
			results.add(result);
		}

		return results;
	}
}
