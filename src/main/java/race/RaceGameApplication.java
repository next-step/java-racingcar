package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		InputView inputView = InputView.settingInputView();
		RaceGameProcessor gameProcessor = RaceGameProcessor.ofInputView(inputView, new RandomMovePolicy());
		new OutputView(gameProcessor.getGameSubject());
		gameProcessor.running();
	}
}
