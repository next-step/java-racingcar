package racingcar.step3;

public class RacingCarApp {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		GameAttribute gameAttribute = inputView.getGameAttribute();

		ResultView resultView = new ResultView();
		Game game = new Game(resultView);
		game.play(gameAttribute);
	}
}
