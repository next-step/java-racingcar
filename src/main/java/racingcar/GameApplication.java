package racingcar;

public class GameApplication {
	private static String[] carName;
	private static Integer executeSize = 0;

	public static void main(String[] args) {
		getInput();
		Game game = new Game(carName);
		GameResult gameResult = game.run(executeSize);
		printResult(gameResult);
	}

	private static void getInput() {
		InputView<String[]> inputViewCarName = new InputViewCarName("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		carName = inputViewCarName.getInput();

		InputView<Integer> inputViewNumber = new InputViewNumber("시도할 회수는 몇 회인가요?");
		executeSize = inputViewNumber.getInput();
	}

	private static void printResult(GameResult gameResult) {
		ResultView resultView = new ResultView();
		resultView.printResult(gameResult);
	}
}
