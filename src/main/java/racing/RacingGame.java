package racing;

import racing.car.CarName;
import racing.car.RacingCarGroup;
import racing.car.RandomMoveChanceGenerator;

import java.util.List;

class RacingGame {
	private final RacingCarGroup racingCarGroup;
	private final int turn;
	private final RacingNotifier racingNotifier;

	RacingGame(List<CarName> carNameList, int turn, RacingNotifier racingNotifier) {
		this.racingCarGroup = RacingCarGroup.of(carNameList, new RandomMoveChanceGenerator());
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
