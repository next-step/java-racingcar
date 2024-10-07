package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingHistory {
	List<MovedHistory> movedHistories;

	public RacingHistory() {
		this.movedHistories = new ArrayList<>();
	}

	public void writePositionHistory(MovedHistory movedHistory) {
		this.movedHistories.add(movedHistory);
	}

	public List<MovedHistory> getMovedHistories() {
		return movedHistories;
	}

	public Integer getMovedCount() {
		return movedHistories.size();
	}
}
