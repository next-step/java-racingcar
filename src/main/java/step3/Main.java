package step3;

import step3.view.InputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		String inputCarName = inputView.getInputCarName();
		int inputTime = inputView.getInputTime();

		RacingGame racingGame = new RacingGame(inputCarName, inputTime);
		racingGame.run();
	}
}
