package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		InputValue inputValue = InputView.makeGameInputValue();
		RaceGameProcessor gameProcessor = new RaceGameProcessor(inputValue, new RandomMovePolicy());
		new OutputView(gameProcessor.getGameSubject());
		gameProcessor.running();
	}
}
