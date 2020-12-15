package step3.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

	private final MoveDistance maxMoveDistance;
	private final RacingCars winners;

	public Referee(final RacingCars racingCars) {
		this.maxMoveDistance = getMaxMoveDistance(racingCars);
		this.winners = judgeWinners(racingCars);
	}

	private MoveDistance getMaxMoveDistance(final RacingCars racingCars) {
		return new MoveDistance(racingCars.getRacingCars().stream()
			.mapToInt(RacingCar::getMoveDistance)
			.max()
			.orElse(0));
	}

	private RacingCars judgeWinners(final RacingCars racingCars) {
		final List<RacingCar> winners = new ArrayList<>();
		for (final RacingCar racingCar : racingCars.getRacingCars()) {
			addWinner(winners, racingCar);
		}
		return new RacingCars(winners);
	}

	private void addWinner(final List<RacingCar> winners, final RacingCar racingCar) {
		if (racingCar.isSameMoveDistance(this.maxMoveDistance)) {
			winners.add(racingCar);
		}
	}

	public RacingCars getWinners() {
		return this.winners;
	}

	public int getMaxMoveDistance() {
		return maxMoveDistance.getMoveDistance();
	}

}
