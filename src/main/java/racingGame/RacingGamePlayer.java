package racingGame;

import racingGame.domain.RacingGame;
import racingGame.ui.InputView;
import racingGame.ui.ResultView;

public class RacingGamePlayer {
	private InputView inputView;
	private ResultView resultView;

	public RacingGamePlayer() {
		inputView = new InputView();
		resultView = new ResultView();
	}

	public void racingStart() {
		inputView.startInput();
		RacingGame racingGame = new RacingGame(inputView.getRacers());

		resultView.printResultStart();
		for (int i = 0; i < inputView.getRacingTime(); i++) {
			racingGame.move();
			resultView.printResult(racingGame.getCars());
			System.out.println();
		}
		resultView.printWinner(racingGame.getWinners());
	}

	public static void main(String[] args) {
		new RacingGamePlayer().racingStart();
	}
}
