package study.racingcar.domain;

import java.util.List;

import study.racingcar.view.ResultView;
import study.racingcar.domain.strategy.MoveStrategy;

public class RacingGame {
	private final Cars cars;
	private final int tryNo;

	public RacingGame(List<Name> carNames, int rounds) {
		this.cars = new Cars(carNames);
		this.tryNo = rounds;
	}

	public Cars racing(MoveStrategy strategy) {
		for (int i = 0; i < tryNo; i++) {
			Cars cars = this.cars.goRace(strategy);
			currentScore(cars);
		}
		return cars;
	}

	private void currentScore(Cars cars) {
		ResultView.printCurrentRacingResult(cars);
	}

}
