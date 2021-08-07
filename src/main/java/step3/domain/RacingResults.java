package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResults {
	private List<RacingResult> results;

	public RacingResults(List<Car> cars) {
		this.results = cars.stream()
			.map(car -> new RacingResult(car.getName(), car.getPosition()))
			.collect(Collectors.toList());
	}

	public List<RacingResult> getResults() {
		return results;
	}
}
