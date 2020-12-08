package race;

public class SimpleRaceGameFactory implements RaceGameFactory {

	private final int tryTimes;
	private final CarGroup carGroup;

	public SimpleRaceGameFactory(String names, int tryTimes) {
		this.tryTimes = tryTimes;
		this.carGroup = CarGroup.ofCarNames(names, new SimpleMovePolicy());
	}

	@Override
	public RaceGameResult start() {
		RaceGameResult raceGameResult = new RaceGameResult();
		for (int currentTryCount = 0; currentTryCount < this.tryTimes; currentTryCount++) {
			raceGameResult.addHistory(new RaceGameResultMessage(this.carGroup.moveAll()));
		}
		return raceGameResult;
	}
}
