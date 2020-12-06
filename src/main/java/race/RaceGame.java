package race;

import java.util.ArrayList;
import java.util.List;

public class RaceGame implements GameSubject {
	private static final String INPUT_NAME_SEPARATOR = ",";
	private static final String MOVE_SEPARATOR = "-";
	private final List<GameObserver> gameObserver = new ArrayList<>();
	private final CarGroup raceCarGroup;

	public RaceGame(int carAmount, MovePolicy movePolicy) {
		this.raceCarGroup = CarGroup.of(carAmount, movePolicy);
	}

	public RaceGame(String names, MovePolicy movePolicy) {
		this.raceCarGroup = CarGroup.ofNames(INPUT_NAME_SEPARATOR, names, movePolicy);
	}

	@Override
	public void registerObserver(GameObserver gameObserver) {
		this.gameObserver.add(gameObserver);
	}

	@Override
	public void notifyObserver() {
		this.notifyObserveRun();
	}

	private void notifyObserveRun() {
		this.raceCarGroup.moveAll();
		sendMessageToObserver();
	}

	private void sendMessageToObserver() {
		for (GameObserver observer : gameObserver) {
			observer.update(createGameResultMessage());
		}
	}

	public String createGameResultMessage() {
		return new GameResultMessage(MOVE_SEPARATOR).parser(this.raceCarGroup.nowCarStatus());
	}
}
