package racing;

import racing.view.InputView;
import racing.view.RacingNotifyView;

import java.util.List;

public class RacingGameStarter {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		List<String> carNameList = inputView.inputCarNameList();
		int raceTurn = inputView.inputRaceTurn();

		RacingGame racingGame = new RacingGame(carNameList, raceTurn, new RacingNotifyView());
		racingGame.start();
	}
}
