package racing.domain;

import java.util.Map;

public class FinalRacingResult {
	private int maxPosition;

	private Map<Integer, String> racingResults;

	private String winnerName;

	public FinalRacingResult(int maxPosition, Map<Integer, String> racingResults, String winnerName) {
		this.maxPosition = maxPosition;
		this.racingResults = racingResults;
		this.winnerName = winnerName;
	}

	public String getWinnerName() {
		return winnerName;
	}
}
