package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingResults {
	private List<RacingResult> results;

	public RacingResults(List<RacingResult> results) {
		this.results = results;
	}

	public List<RacingResult> getResults() {
		return results;
	}

	public List<String> winners() {
		int maxMoveCount = getMaxMoveCount();
		return this.results.stream()
			.filter(result -> result.getMoveCount() == maxMoveCount)
			.map(RacingResult::getName)
			.collect(Collectors.toList());
	}

	private int getMaxMoveCount() {
		return this.results.stream()
			.mapToInt(RacingResult::getMoveCount)
			.max().orElse(0);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof RacingResults))
			return false;
		RacingResults that = (RacingResults)o;
		return Objects.equals(results, that.results);
	}
}
