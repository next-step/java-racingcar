package step2;

import java.util.Random;

public class RacingGame {
	private int time;

	private int[] carPositions;

	public static void main(String[] args) {
		InputView inputView = new InputView();
		UserInput userInput = inputView.getUserInput();

		RacingGame racingGame = new RacingGame();
		racingGame.initSetting(userInput);
		racingGame.doRacing();
	}

	private void initSetting(UserInput userInput) {
		time = userInput.getMOVE_COUNT();
		carPositions = new int[userInput.getCAR_COUNT()];
	}

	private void doRacing() {
		for (int i = 0; i < time; i++) {
			move();
		}
	}

	private void move() {
		Random random = new Random();
		for (int i = 0; i < carPositions.length; i++) {
			int randomNumber = random.nextInt(10);

			if (randomNumber >= 4) {
				carPositions[i]++;
			}
		}
	}
}