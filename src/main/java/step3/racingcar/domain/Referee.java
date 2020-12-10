package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

	private final int maxMoveDistance;
	private final RacingCars winners;

	public Referee(final RacingCars racingCars) {
		this.maxMoveDistance = getMaxMoveDistance(racingCars);
		this.winners = judgeWinners(racingCars);
	}

	private int getMaxMoveDistance(final RacingCars racingCars) {
		int maxMoveDistance = 0;
		for (final RacingCar racingCar : racingCars.getRacingCars()) {
			maxMoveDistance = Math.max(maxMoveDistance, racingCar.getMoveDistance());
		}
		return maxMoveDistance;
	}

	private RacingCars judgeWinners(final RacingCars racingCars) {
		final List<RacingCar> winners = new ArrayList<>();
		for (final RacingCar racingCar : racingCars.getRacingCars()) {
			addWinner(winners, racingCar);
		}
		return new RacingCars(winners);
	}

	private void addWinner(final List<RacingCar> winners, final RacingCar racingCar) {
		if (this.maxMoveDistance != racingCar.getMoveDistance()) {
			return;
		}
		winners.add(racingCar);
	}

	public RacingCars getWinners() {
		return this.winners;
	}

}
