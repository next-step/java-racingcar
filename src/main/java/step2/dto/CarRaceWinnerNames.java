package step2.dto;

import java.util.ArrayList;
import java.util.List;

public class CarRaceWinnerNames {

	private final List<String> winnerNames;

	private CarRaceWinnerNames(List<String> winnerNames) {
		this.winnerNames = winnerNames;
	}

	public static CarRaceWinnerNames of(List<String> winnerNames) {
		return new CarRaceWinnerNames(winnerNames);
	}

	public boolean isEmpty() {
		return winnerNames.isEmpty();
	}

	public List<String> get() {
		return new ArrayList<>(winnerNames);
	}

}
