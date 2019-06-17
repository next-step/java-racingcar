package racinggame;

import racinggame.model.RacingGame;
import racinggame.view.ResultView;

public class RacingGameMain {
	public static void main(String[] args) {
		RacingGame racingGame = new RacingGame();
		ResultView.resultView(racingGame.startGame());
	}
}
