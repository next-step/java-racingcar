package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	public static List<RacingResults> race(int trials, String[] nameOfCars) {
		Cars cars = new Cars(nameOfCars);

		List<RacingResults> results = new ArrayList<>();

		for (int i = 0; i < trials; i++) {
			cars.raceOneTrial();
			RacingResults result = new RacingResults(cars);
			results.add(result);
		}

		return results;
	}
}
