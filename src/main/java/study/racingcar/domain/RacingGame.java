package study.racingcar.domain;

import java.util.List;

import study.racingcar.view.ResultView;

public class RacingGame {
	private final Cars cars;
	private final int rounds;
	private final MoveStrategy strategy;

	public RacingGame(List<String> userInputCarNames, int userInputRound, MoveStrategy strategy) {
		this.cars = new Cars(userInputCarNames);
		this.rounds = userInputRound;
		this.strategy = strategy;
	}

	public void playGame() {
		for (int i = 0; i < rounds; i++) {
			moveCars();
			currentScore();
		}

		winner();
	}

	private void winner() {
		List<Car> cars = this.cars.statusOfCars();
		List<String> winners = getWinner(cars);
		ResultView.printWinner(winners);
	}

	private List<String> getWinner(List<Car> cars) {
		Winner winner = new Winner(cars);
		int maxPosition = winner.maxPosition();
		return winner.whoIsWinner(maxPosition);
	}

	public List<Car> carsCurrentStatus() {
		return cars.statusOfCars();
	}

	private void moveCars() {
		cars.goRace(strategy);
	}

	private void currentScore() {
		ResultView.printCurrentRacingResult(this);
	}

}
