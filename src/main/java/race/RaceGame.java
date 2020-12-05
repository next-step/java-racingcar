package race;

public class RaceGame implements GameSubject {
	private static final String MOVE_SEPARATOR = "-";
	private GameObserver gameObserver;
	private final CarGroup raceCarGroup;

	public RaceGame(int carAmount) {
		this.raceCarGroup = CarGroup.of(carAmount, new SimpleMovePolicy());
	}

	public RaceGame(int carAmount, MovePolicy movePolicy) {
		this.raceCarGroup = CarGroup.of(carAmount, movePolicy);
	}

	@Override
	public void registerObserver(GameObserver gameObserver) {
		this.gameObserver = gameObserver;
	}

	@Override
	public void notifyObserver() {
		this.run();
	}

	private void sendMessageToObserver() {
		this.gameObserver.update(createGameResultMessage());
	}

	private void run() {
		this.raceCarGroup.moveAll();
		sendMessageToObserver();
	}

	private String createGameResultMessage() {
		return new GameResultMessage(MOVE_SEPARATOR).parser(this.raceCarGroup.nowCarStatus());
	}
}
