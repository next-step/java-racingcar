package racingcar.wrapper;

import java.util.ArrayList;
import java.util.List;

import racingcar.RacingCar;

public class Winners {
	private List<String> winners = new ArrayList<>();

	public Winners() {
	}

	public void select(RacingCar car, int maxScore) {
		if (maxScore == car.getTotalScore()) {
			winners.add(car.getName());
		}
	}

	public List<String> get() {
		return winners;
	}
}
