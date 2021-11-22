package study.racingcar.domain;

import java.util.List;

import study.racingcar.view.ResultView;

public class RacingGame {
	private final Cars cars;
	private final int rounds;
	private final MoveStrategy strategy;

	public RacingGame(int userInputCar, int userInputRound, MoveStrategy strategy) {
		this.cars = new Cars(userInputCar);
		this.rounds = userInputRound;
		this.strategy = strategy;
	}

	public void playGame() {
		for (int i = 0; i < rounds; i++) {
			moveCars();
			currentScore();
		}
	}

	public List<Position> carsCurrentPosition() {
		return cars.positionOfCars();
	}

	private void moveCars() {
		cars.goRace(strategy);
	}

	private void currentScore() {
		ResultView.printCurrentRacingResult(this);
	}

}
