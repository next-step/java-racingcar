package racingcar;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InputView inputView = new InputView();

		RacingGame racingGame
			= new RacingGame(inputView.inputTotalCarNum(sc));
		racingGame.playRounds(inputView.inputTotalRound(sc));

		ResultView resultView = new ResultView();
		resultView.showResult(racingGame.getRounds());
	}
}
