package race;

import java.util.ArrayList;
import java.util.List;

public class RaceGameResult {

	private final List<RaceGameResultMessage> history;

	public RaceGameResult() {
		this.history = new ArrayList<>();
	}

	public void addHistory(RaceGameResultMessage gameResultMessage) {
		this.history.add(gameResultMessage);
	}

	public List<RaceGameResultMessage> getHistory() {
		return this.history;
	}

	public RaceGameResultMessage getLastHistory() {
		return this.history.get(getLastIndex());
	}

	public String getDistanceWinner() {
		return this.getLastHistory().getDistanceWinner();
	}

	private int getLastIndex() {
		return this.history.size() - 1;
	}
}
