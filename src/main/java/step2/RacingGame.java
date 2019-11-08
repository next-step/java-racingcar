package step2;

import java.util.Random;

public class RacingGame {

	private static final int LIMIT_NUMBER = 10;

	private static final int DELIMITER_NUMBER = 4;

	private UserInput userInput;

	private int[] carPositions;

	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		racingGame.setting();
		racingGame.doRacing();
	}

	private void setting() {
		InputView inputView = new InputView();
		userInput = inputView.getUserInput();
		carPositions = new int[userInput.getCAR_COUNT()];
	}

	private void doRacing() {
		ResultView resultView = new ResultView();
		for (int i = 0; i < userInput.getMOVE_COUNT(); i++) {
			processRacingTurn();
			resultView.printCars(carPositions);
		}
	}

	private void processRacingTurn() {
		for (int i = 0; i < carPositions.length; i++) {
			moveCar(i);
		}
	}

	private void moveCar(int carNo) {
		Random random = new Random();
		int randomNumber = random.nextInt(LIMIT_NUMBER);

		if (randomNumber >= DELIMITER_NUMBER) {
			carPositions[carNo]++;
		}
	}
}