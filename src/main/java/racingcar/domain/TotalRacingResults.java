package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalRacingResults {
	private List<RacingResults> totalResults;

	public TotalRacingResults(List<RacingResults> totalResults) {
		if (totalResults == null) {
			totalResults = new ArrayList<>();
		}
		this.totalResults = totalResults;
	}

	public List<RacingResults> getTotalResults() {
		return totalResults;
	}

	public List<String> winners() {
		if (this.totalResults.size() == 0) {
			return new ArrayList<>();
		}
		return finalResult().winners();
	}

	private RacingResults finalResult() {
		return this.totalResults.get(this.totalResults.size() - 1);
	}
}
