package racing;

import racing.UI.InputView;

import java.util.ArrayList;

public class RacingGameStart {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		inputView.input();

		RacingGame game = new RacingGame(inputView.getCars(), inputView.getTimes());

		ArrayList<Integer> carPositions = game.getCarPositions();
	}
}
