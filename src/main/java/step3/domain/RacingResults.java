package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingResults {
	private List<RacingResult> results;

	public RacingResults(Cars cars) {
		this.results = cars.getCars()
			.stream()
			.map(car -> new RacingResult(car.getName(), car.getPosition()))
			.collect(Collectors.toList());
	}

	public List<RacingResult> getResults() {
		return results;
	}

	private int getHighestPosition() {
		return results.stream()
			.mapToInt(RacingResult::getPosition)
			.max()
			.getAsInt();
	}

	public List<String> getChampions() {
		return results.stream()
			.filter(result -> result.getPosition() == getHighestPosition())
			.map(RacingResult::getName)
			.collect(Collectors.toList());
	}
}
