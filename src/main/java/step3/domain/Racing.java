package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
	public static List<RacingResults> race(int trials, String[] nameOfCars) {
		Cars cars = new Cars(nameOfCars);

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
