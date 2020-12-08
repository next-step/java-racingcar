package race;

public class RaceGameModel {
	private final CarGroup raceCarGroup;

	public RaceGameModel(CarGroup raceCarGroup) {
		this.raceCarGroup = raceCarGroup;
	}

	public RaceGameHistory start(int tryTimes) {
		RaceGameHistory raceGameHistory = new RaceGameHistory();
		for (int currentMoveCount = 0; currentMoveCount < tryTimes; currentMoveCount++) {
			raceGameHistory.addHistory(new RaceGameResultMessage(raceCarGroup.moveAll()));
		}
		return raceGameHistory;
	}
}
