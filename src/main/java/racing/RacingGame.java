package racing;

import racing.car.CarGroup;
import racing.car.RandomMoveForwardStrategy;

import java.util.List;

class RacingGame {
	private final CarGroup carGroup;
	private final int turn;
	private final RacingNotifier racingNotifier;

	RacingGame(List<String> carNameList, int turn, RacingNotifier racingNotifier) {
		this.carGroup = CarGroup.of(carNameList, new RandomMoveForwardStrategy());
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	CarGroup start() {
		for (int i = 0; i < turn; i++) {
			this.carGroup.getMoveForwardChance();
			this.racingNotifier.notifyRace(this.carGroup);
		}

		this.racingNotifier.notifyWinner(this.carGroup.getWinnerNameList());
		return this.carGroup;
	}
}
