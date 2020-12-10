package carracinggame;

public class CarRacingGameStarter {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		int carCount = inputView.printAndGetCarCount();
		int moveCount = inputView.printAndGetMoveCount();

		CarRacingGame carRacingGame = new CarRacingGame();
		carRacingGame.start(carCount, moveCount, resultView);
	}
}
