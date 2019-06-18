package racinggame;

import racinggame.model.RacingGame;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class RacingGameMain {
	public static void main(String[] args) {

		int carCount = InputView.input("자동차 대수는 몇 대 인가요?");
		int time = InputView.input("시도할 회수는 몇 회 인가요?");

		RacingGame racingGame = new RacingGame(carCount);

		for (int i = 0; i < time; i++) {
			ResultView.resultView(racingGame.startGame());
			System.out.println();
		}
	}
}
