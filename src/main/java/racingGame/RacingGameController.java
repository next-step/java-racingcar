package racingGame;

import java.util.Scanner;

import racingGame.domain.RacingGameCenter;
import racingGame.domain.ScoreBoard;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGameController {
	public static void main(String[] args) {
		// Input
		RacingGameCenter racingGameCenter = new RacingGameCenter(InputView.inputCarNames(), InputView.inputCountOfTimes());
		
		// Game Start
		ScoreBoard scoreBoard = racingGameCenter.gameStart();
		
		// Output
		OutputView.printGameScore(scoreBoard);
	}
}
