package racingGame;

import java.util.List;
import java.util.Scanner;

import racingGame.domain.RacingCar;
import racingGame.domain.RacingGameCenter;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGameMain {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		RacingGameCenter racingGameCenter = new RacingGameCenter(InputView.inputCountOfCars(sc), InputView.inputCountOfTimes(sc));
		
		// Game Start
		String[][] gameScore = racingGameCenter.gameStart();
		
		// Output
		OutputView.printGameScore(gameScore);
	}
}
