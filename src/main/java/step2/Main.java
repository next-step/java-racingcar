package step2;

import step2.view.InputView;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		int carNum = inputView.getCarNum();
		int tryNum = inputView.getTryNum();

		RacingGame racingGame = new RacingGame(carNum, tryNum);
		racingGame.run();
	}
}
