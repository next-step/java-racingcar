package racing;

import racing.car.CarGroup;
import racing.car.RandomMoveForwardStrategy;

import java.util.List;

public class RacingGame {
	private final CarGroup carGroup;
	private final int turn;
	private final RacingNotifier racingNotifier;

	public RacingGame(List<String> carNameList, int turn, RacingNotifier racingNotifier) {
		this.carGroup = CarGroup.of(carNameList, new RandomMoveForwardStrategy());
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
