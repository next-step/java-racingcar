package race;

public class RaceGame implements GameSubject {
	private GameObserver gameObserver;
	private final CarGroup raceCarGroup;
	private String carDistanceMessage;

	public RaceGame(int carAmount, GameObserver gameObserver) {
		this.raceCarGroup = CarGroup.of(carAmount, new SimpleMovePolicy());
		this.registerObserver(gameObserver);
	}

	@Override
	public void registerObserver(GameObserver gameObserver) {
		this.gameObserver = gameObserver;
	}

	@Override
	public void notifyObserver() {
		this.run();
		gameObserver.update(this.carDistanceMessage);
	}

	public void run() {
		this.raceCarGroup.moveAll();
		this.carDistanceMessage = new GameResultMessage("-").parser(this.raceCarGroup.nowCarStatus());
	}
}
