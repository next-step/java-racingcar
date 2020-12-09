package race.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGameResult {

	private final List<RaceGameResultMessage> gameResults;

	public RaceGameResult() {
		this.gameResults = new ArrayList<>();
	}

	public void addResult(RaceGameResultMessage gameResultMessage) {
		this.gameResults.add(gameResultMessage);
	}

	public String getGameResults() {
		return this.gameResults
			.stream()
			.map(RaceGameResultMessage::parser)
			.collect(Collectors.joining(RaceGameResultMessage.TRY_SEPARATOR));
	}

	public RaceGameResultMessage getLastGameResult() {
		return this.gameResults.get(getLastIndex());
	}

	public String getDistanceWinner() {
		return this.getLastGameResult().getDistanceWinner();
	}

	private int getLastIndex() {
		return this.gameResults.size() - 1;
	}
}
