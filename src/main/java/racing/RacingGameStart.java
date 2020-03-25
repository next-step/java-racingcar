package racing;

import racing.ui.InputView;
import racing.ui.ResultView;

public class RacingGameStart {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		inputView.input();

		RacingGame game = new RacingGame(inputView.getCars(), inputView.getTimes());
		
		ResultView resultView = new ResultView();
		resultView.printTitle();
		
		for ( int i = 0; game.isInTime(i); ++i ) {
			resultView.print(game.move());
		}
		
		resultView.printWinner(game.getWinner());
	}
}
