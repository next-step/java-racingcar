package racingcar;

public class GameApplication {
	private static String[] carName;
	private static int executeSize = 0;

	public static void main(String[] args) {
		getInput();
		Game game = new Game(carName);
		game.run(executeSize);
	}

	private static void getInput() {
		InputView inputView = new InputView("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		carName = inputView.getInputCarName();

		inputView = new InputView("시도할 회수는 몇 회인가요?");
		executeSize = inputView.getInputNumber();
	}
}
