package step5_racingcar_refactoring.service;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Winner {

	Set<String> winners = new LinkedHashSet<>();

	private int maxValue = 0;

	public void selectWinner(Map<String, Integer> roundResult) {
		for (Map.Entry<String, Integer> entry : roundResult.entrySet()) {
			validateWinner(entry.getKey(), entry.getValue());
		}
	}

	public void validateWinner(String name, int position) {

		if (position > this.maxValue) {
			winners.clear();
			this.maxValue = position;
			winners.add(name);
			return;
		}

		if (position == this.maxValue) {
			this.maxValue = position;
			winners.add(name);
			return;
		}

		if (winners.contains(name)) {
			winners.remove(name);
			return;
		}
	}

	public Set<String> getNames() {
		return winners;
	}
}
