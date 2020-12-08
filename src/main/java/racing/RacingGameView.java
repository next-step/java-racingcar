package racing;

public class RacingGameView {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		int carNum = inputView.inputCarNum();
		int raceTurn = inputView.inputRaceTurn();

		RacingGame racingGame = new RacingGame(carNum, raceTurn, new RacingNotifyView());
		racingGame.start();
	}
}
