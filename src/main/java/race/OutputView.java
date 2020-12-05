package race;

public class OutputView implements GameObserver {
	private String gameResultMessage;

	@Override
	public void update(String message) {
		this.gameResultMessage = message;
	}

	public String getGameResultMessage() {
		return gameResultMessage;
	}
}
