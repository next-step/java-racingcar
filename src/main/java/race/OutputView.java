package race;

public class OutputView implements GameObserver {
	private String gameResultMessage;

	public OutputView(GameSubject gameSubject) {
		gameSubject.registerObserver(this);
	}

	@Override
	public void update(String message) {
		this.gameResultMessage = message;
		sendMessageToUser();
	}

	public String getGameResultMessage() {
		return gameResultMessage;
	}

	public void sendMessageToUser() {
		System.out.println(gameResultMessage + GameResultMessage.TRY_SEPARATOR);
	}
}
