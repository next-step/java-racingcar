package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		InputView inputView = InputView.settingInputView();
		GameProcessor gameProcessor = GameProcessor.ofInputView(inputView, new RandomMovePolicy());
		new OutputView(gameProcessor.getGameSubject());
		gameProcessor.running();
	}
}
