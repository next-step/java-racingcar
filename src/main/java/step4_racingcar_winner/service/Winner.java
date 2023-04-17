package step4_racingcar_winner.service;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Winner {
	private Set<String> winnerNames = new LinkedHashSet<>();
	private int maxValue = 0;

	public void selectWinner(Map<String, Integer> roundResult)
	{
		for (Map.Entry<String, Integer> entry : roundResult.entrySet()) {
			validateWinner(entry.getKey(), entry.getValue());
		}
	}

	public void validateWinner(String name, int position) {

		if (position > this.maxValue) {
			winnerNames.clear();
			this.maxValue = position;
			winnerNames.add(name);
			return;
		}

		if (position == this.maxValue) {
			this.maxValue = position;
			winnerNames.add(name);
			return;
		}

		if (winnerNames.contains(name)) {
			winnerNames.remove(name);
			return;
		}
	}

	public String getWinner()
	{
		String winners = String.join(", ", winnerNames);

		return winners;
	}
}
