package im.juniq.racingcar;

import im.juniq.racingcar.domain.Cars;
import im.juniq.racingcar.view.InputView;
import im.juniq.racingcar.view.ResultView;

public class RacingGame {
	private Cars cars = new Cars();
	private ResultView resultView = new ResultView();

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.play();
	}

	public void play() {
		InputView inputView = new InputView();
		inputView.scan();
		createCars(inputView.getCarNames());
		racing(inputView.getNumberOfTries());
		printWinner();
	}

	private void createCars(String[] carNames) {
		cars.createCars(carNames);
	}

	private void racing(int numberOfTries) {
		for (int i = 0; i < numberOfTries; i++) {
			moveCars();
			printScore();
		}
	}

	private void moveCars() {
		cars.move();
	}

	private void printScore() {
		resultView.printCarsStatus(cars);
	}

	private void printWinner() {
		resultView.printWinner(cars.findByTopPosition());
	}
}
