package study.racingcar.domain;

import java.util.List;

import study.racingcar.view.ResultView;

public class RacingGame {
	private final Cars cars;
	private final Rounds rounds;

	public RacingGame(UserChoice userChoice) {
		this.cars = new Cars(userChoice.userCarCount());
		this.rounds = new Rounds(userChoice.userGameRounds());
	}

	public void playGame() {
		int gameRounds = rounds.numOfRounds();
		for (int i = 0; i < gameRounds; i++) {
			moveCars();
			currentScore();
		}
	}

	public List<Position> carsCurrentPosition() {
		return cars.positionOfCars();
	}

	private void moveCars() {
		cars.goRace();
	}

	private void currentScore() {
		ResultView.printCurrentRacingResult(this);
	}

}
