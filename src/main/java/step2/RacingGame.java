package step2;

public class RacingGame {
	private int time;
	private int[] carPositions;

	public static void main(String[] args) {
		InputView inputView = new InputView();
		UserInput userInput = inputView.getUserInput();

		RacingGame racingGame = new RacingGame();
		racingGame.initSetting(userInput);
	}

	private void initSetting(UserInput userInput) {
		time = userInput.getMOVE_COUNT();
		carPositions = new int[userInput.getCAR_COUNT()];
	}
}