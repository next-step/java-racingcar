package racingcar;

public class GameApplication {
	private static int carSize = 0;
	private static int executeSize = 0;

	public static void main(String[] args) {
		getInput();
		Game game = new Game(carSize);
		game.run(executeSize);
	}

	private static void getInput() {
		InputView inputView = new InputView();
		inputView.setText("자동차 대수는 몇 대인가요?");
		carSize = inputView.getScanner();

		inputView.setText("시도할 회수는 몇 회 인가요?");
		executeSize = inputView.getScanner();
	}
}
