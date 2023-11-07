package racingcar;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InputView inputView = new InputView();

		MoveStrategy strategy = new RandomStrategy();

		RacingGame racingGame
			= new RacingGame(inputView.inputTotalCarNum(sc));
		racingGame.playRounds(inputView.inputTotalRound(sc), strategy);

		ResultView resultView = new ResultView();
		resultView.showRoundsResult(racingGame.getRounds());
		resultView.showWinners(racingGame.getWinners());
	}
}
