package study.racingcar.domain;

import java.util.List;

import study.racingcar.view.ResultView;

public class RacingGame {
	private final Cars cars;
	private final int rounds;

	public RacingGame(int userInputCar, int userInputRound) {
		this.cars = new Cars(userInputCar);
		this.rounds = userInputRound;
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
		MoveStrategy strategy = new RandomNumberStrategy();
		cars.goRace(strategy);
	}

	private void currentScore() {
		ResultView.printCurrentRacingResult(this);
	}

}
