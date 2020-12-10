package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
	private final List<Integer> results = new ArrayList<>();

	public void addResult(int position) {
		results.add(position);
	}

	public List<Integer> getResults() {
		return results;
	}
}
