package race;

public class OutputView implements GameObserver {
	private final RaceGameController raceGameController;

	public OutputView(RaceGameController raceGameController) {
		this.raceGameController = raceGameController;
		this.raceGameController.registerGameObserver(this);
	}

	@Override
	public void update() {
		sendMessageToUser();
	}

	public String getGameResultMessage() {
		return this.raceGameController.getNowCarsMoveStatus();
	}

	public void sendMessageToUser() {
		System.out.println(this.raceGameController.getNowCarsMoveStatus() + RaceGameResultMessage.TRY_SEPARATOR);

		if (this.raceGameController.isOverTryTimes()) {
			System.out.println(this.raceGameController.getRaceGameWinner());
		}
	}
}
