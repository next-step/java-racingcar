package racing;

import racing.UI.InputView;
import racing.UI.ResultView;

import java.util.ArrayList;

public class RacingGameStart {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		inputView.input();

		RacingGame game = new RacingGame(inputView.getCars(), inputView.getTimes());

		ArrayList<Integer> carPositions;

		ResultView resultView = new ResultView();
		resultView.printTitle();

		for (int i = 0; i < game.getTime(); ++i) {
			carPositions = game.move();
			resultView.print(carPositions);
		}
	}
}
