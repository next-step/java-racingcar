package race;

public class OutputView implements GameObserver {
	private final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";
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
			System.out.println(String.format(WINNER_MESSAGE, this.raceGameController.getRaceGameWinner()));
		}
	}
}
