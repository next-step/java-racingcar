package race;

public class RaceGameApplication {

	public static void main(String[] args) {
		GameProcessor gameProcessor = new InputView().settingGame();
		new OutputView(gameProcessor.getGameSubject());
		gameProcessor.running();
	}
}
