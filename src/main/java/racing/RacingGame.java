package racing;

import racing.car.RacingCarGroup;
import racing.car.RandomMoveForwardStrategy;

import java.util.List;

class RacingGame {
	private final RacingCarGroup racingCarGroup;
	private final int turn;
	private final RacingNotifier racingNotifier;

	RacingGame(List<String> carNameList, int turn, RacingNotifier racingNotifier) {
		this.racingCarGroup = RacingCarGroup.of(carNameList, new RandomMoveForwardStrategy());
		this.turn = turn;
		this.racingNotifier = racingNotifier;
	}

	RacingCarGroup start() {
		for (int i = 0; i < turn; i++) {
			this.racingCarGroup.getMoveForwardChance();
			this.racingNotifier.notifyRace(this.racingCarGroup);
		}

		this.racingNotifier.notifyWinner(this.racingCarGroup.getWinnerNameList());
		return this.racingCarGroup;
	}
}
