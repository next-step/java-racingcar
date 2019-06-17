package racing;

import java.util.ArrayList;
import java.util.List;

public class Stage {

	private List<RacingCar> players;

	private int round;

	private Stage(StageBuilder stageBuilder){
		this.round = stageBuilder.round;
		this.players = stageBuilder.players;

	}

	public int getCountOfPlayers() {
		return players.size();
	}

	public int remainingRounds() {
		return round;
	}

	public void playRound() {

		if (round == 0){
			throw new PlayOverException("레이싱이 종료되었습니다.");
		}

		for(RacingCar car : players){
			car.accelerate(1);
		}

		round -= 1;
	}

	/**
	 * @param entrySize	참여가능한 최대 플레이어 수
	 * @param round 게임 라운드 수
	 * @return
	 */
	public static StageBuilder builder(int entrySize, int round) {

		return new StageBuilder(entrySize, round);
	}


	public static class StageBuilder{

		private int entrySize;

		private int round;

		List<RacingCar> players;

		private StageBuilder(int entrySize, int round) {
			this.entrySize = entrySize;
			this.round = round;
			players = new ArrayList<>();
		}

		public Stage build() {
			return new Stage(this);
		}

		public void addToEntry(RacingCar racingCar) {
			players.add(racingCar);
		}

		public void addWatcher(Broadcaster mock) {
		}
	}
}
