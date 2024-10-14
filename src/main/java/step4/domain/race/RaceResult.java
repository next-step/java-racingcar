package step4.domain.race;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RaceResult {
	List<Map<String, Integer>> raceHistory;
	int movedCount;

	public RaceResult(List<Map<String, Integer>> raceHistory) {
		this.raceHistory = raceHistory;
		movedCount = raceHistory.size();
	}

	private static int comparePosition(Integer position, int maxPosition) {
		if (position > maxPosition) {
			maxPosition = position;
		}
		return maxPosition;
	}

	protected static List<String> getWinners(Map<String, Integer> endResult, int maxPosition) {
		List<String> winnerList = new ArrayList<>();
		endResult.forEach((key, value) -> {
			if (value == maxPosition) {
				winnerList.add(key);
			}
		});
		return winnerList;
	}

	private static int getMaxPosition(Map<String, Integer> endResult, int maxPosition) {
		for (Integer position : endResult.values()) {
			maxPosition = comparePosition(position, maxPosition);
		}
		return maxPosition;
	}

	public int getMovedCount() {
		return movedCount;
	}

	public Map<String, Integer> getNamePositionMapByTime(int time) {
		return raceHistory.get(time);
	}

	public List<String> getWinnerNameList() {
		int maxPosition = 0;
		Map<String, Integer> endResult = raceHistory.get(movedCount - 1);
		maxPosition = getMaxPosition(endResult, maxPosition);
		return getWinners(endResult, maxPosition);
	}
}
