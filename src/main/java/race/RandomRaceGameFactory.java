package race;

public class RandomRaceGameFactory implements RaceGameFactory {

	private final int tryTimes;
	private final CarGroup carGroup;

	public RandomRaceGameFactory(String names, int tryTimes) {
		this.tryTimes = tryTimes;
		this.carGroup = CarGroup.ofCarNames(names, new RandomMovePolicy());
	}

	@Override
	public RaceGameHistory start() {
		RaceGameHistory raceGameHistory = new RaceGameHistory();
		for (int currentTryCount = 0; currentTryCount < this.tryTimes; currentTryCount++) {
			raceGameHistory.addHistory(new RaceGameResultMessage(this.carGroup.moveAll()));
		}
		return raceGameHistory;
	}
}
