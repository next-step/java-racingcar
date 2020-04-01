package racing;

import racing.domain.RacingGame;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameStart {

	public static void main(String[] args) {

		InputView inputView = new InputView();
		
		RacingGame game = inputView.createNewGame();
		
		ResultView resultView = new ResultView();
		resultView.printTitle();
		
		for (int i = 1; !game.isEnd(i) ; ++i ) {
			resultView.printProgress(game.move());
		}
		
		resultView.printWinner(game.getWinner());
	}
}
