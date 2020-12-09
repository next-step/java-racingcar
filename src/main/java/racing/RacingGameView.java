package racing;

import java.util.List;

public class RacingGameView {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		List<String> carNameList = inputView.inputCarNameList();
		int raceTurn = inputView.inputRaceTurn();

		RacingGame racingGame = new RacingGame(carNameList, raceTurn, new RacingNotifyView());
		racingGame.start();
	}
}
