package racing;

import racing.UI.InputView;

import java.util.ArrayList;

public class RacingGameStart {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		inputView.input();

		RacingGame game = new RacingGame(inputView.getCars(), inputView.getTimes());

		ArrayList<Integer> carPositions;

		System.out.println("실행 결과");

		for (int i = 0; i < game.getTime(); ++i) {
			carPositions = game.move();
		}
	}
}
