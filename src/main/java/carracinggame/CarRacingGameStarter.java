package carracinggame;

public class CarRacingGameStarter {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		String carNames = inputView.printAndGetCarName();
		int moveCount = inputView.printAndGetMoveCount();

		CarRacingGame carRacingGame = new CarRacingGame();
		carRacingGame.start(carNames, moveCount, resultView);
	}
}
