package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

	public static TotalRacingResults race(List<String> carNames, int tryCount) {
		Cars cars = new Cars(carNames, new RandomNumberGenerator());
		List<RacingResults> totalResults = new ArrayList<>();
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			totalResults.add(cars.racingResults());
		}
		return new TotalRacingResults(totalResults);
	}
}
