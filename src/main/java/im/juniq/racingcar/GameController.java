package im.juniq.racingcar;

import im.juniq.racingcar.domain.RacingGame;
import im.juniq.racingcar.domain.RandomNumberMovingStrategy;
import im.juniq.racingcar.view.InputView;
import im.juniq.racingcar.view.ResultView;

public class GameController {
	private RacingGame racingGame = new RacingGame();
	private ResultView resultView = new ResultView();

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.play();
	}

	public void play() {
		InputView inputView = new InputView();
		inputView.scan();
		createCars(inputView.getCarNames());
		racing(inputView.getNumberOfTries());
		printWinner();
	}

	private void createCars(String[] carNames) {
		racingGame.createCars(carNames, new RandomNumberMovingStrategy());
	}

	private void racing(int numberOfTries) {
		for (int i = 0; i < numberOfTries; i++) {
			moveCars();
			printScore();
		}
	}

	private void moveCars() {
		racingGame.move();
	}

	private void printScore() {
		resultView.printScore(racingGame.carStates());
	}

	private void printWinner() {
		resultView.printWinner(racingGame.getWinners());
	}
}
