package race;

import java.util.ArrayList;
import java.util.List;

public class RaceGameModel implements GameModel {
	private final List<GameObserver> gameObserver = new ArrayList<>();
	private final CarGroup raceCarGroup;
	private int tryTimes = 0;

	public RaceGameModel(int carAmount, MovePolicy movePolicy) {
		this.raceCarGroup = CarGroup.of(carAmount, movePolicy);
	}

	public RaceGameModel(InputValue names, MovePolicy movePolicy) {
		this.raceCarGroup = CarGroup.ofInputValues(names, movePolicy);
	}

	@Override
	public void registerObserver(GameObserver gameObserver) {
		this.gameObserver.add(gameObserver);
	}

	@Override
	public void notifyObserver() {
		this.moveRaceCarGroup();
		this.sendMessageToObserver();
	}

	private void moveRaceCarGroup() {
		this.tryTimes++;
		this.raceCarGroup.moveAll();
	}

	private void sendMessageToObserver() {
		this.gameObserver.forEach(GameObserver::update);
	}

	public RaceGameResultMessage createGameResultMessage() {
		return new RaceGameResultMessage(this.tryTimes, this.raceCarGroup);
	}
}
