package step3;

import java.util.List;

public class RacingInfo {

	private List<Car> participants;

	private int turnCount;

	public List<Car> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Car> participants) {
		this.participants = participants;
	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount(int turnCount) {
		this.turnCount = turnCount;
	}
}
