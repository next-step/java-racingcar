package race.domain;

public class RandomRaceGameFactory implements RaceGameFactory {

	private final int tryTimes;
	private final CarGroup carGroup;

	public RandomRaceGameFactory(String names, int tryTimes) {
		this.tryTimes = tryTimes;
		this.carGroup = CarGroup.ofCarNames(names, new RandomMovePolicy());
	}

	@Override
	public RaceGameResult start() {
		RaceGameResult raceGameResult = new RaceGameResult();
		for (int currentTryCount = 0; currentTryCount < this.tryTimes; currentTryCount++) {
			raceGameResult.addResult(new RaceGameResultMessage(this.carGroup.moveAll()));
		}
		return raceGameResult;
	}
}
