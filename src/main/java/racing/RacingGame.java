package racing;

import racing.car.CarGroup;
import racing.car.RandomMoveForwardStrategy;

public class RacingGame {
	private final CarGroup carGroup;
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(int carNum, int turn, RacingNotifier racingNotifier) {
		this.carGroup = new CarGroup(carNum, new RandomMoveForwardStrategy());
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	public CarGroup start() {
		for (int i = 0; i < turn; i++) {
			carGroup.getMoveForwardChance();
			racingNotifier.notifyRace(this.carGroup);
		}

		return this.carGroup;
	}
}
