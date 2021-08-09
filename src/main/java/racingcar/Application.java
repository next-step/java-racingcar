package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();

		inputView.renderQuestionOfName();
		RacingGame game = new RacingGame(inputView.readString());

		inputView.renderQuestionOfCount();
		int count = inputView.readNumber();

		resultView.renderResultMessage();
		for (int i = 0; i < count; i++) {
			game.run();
			resultView.renderResult(game.getGameResult());
		}
		resultView.renderWinner(game.getWinners());
	}
}
