package racingGame;

import java.util.Scanner;

import racingGame.domain.RacingGameCenter;
import racingGame.domain.ScoreBoard;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGameMain {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		RacingGameCenter racingGameCenter = new RacingGameCenter(InputView.inputCountOfCars(sc), InputView.inputCountOfTimes(sc));
		
		// Game Start
		ScoreBoard scoreBoard = racingGameCenter.gameStart();
		
		// Output
		OutputView.printGameScore(scoreBoard);
	}
}
