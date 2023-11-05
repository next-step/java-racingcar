package racingcar;

public class Main {
	public static void main(String[] args) {
		InputView inputView = new InputView();

		RacingGame racingGame
			= new RacingGame(inputView.getTotalCarNum());
		racingGame.playRounds(inputView.getTotalRound());

		ResultView resultView = new ResultView();
		resultView.showResult(racingGame.getRounds());
	}
}
