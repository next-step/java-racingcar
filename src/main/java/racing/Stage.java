package racing;

import racing.car.RacingCar;
import racing.exception.PlayOverException;
import racing.watcher.RacingWatcher;
import racing.watcher.events.ChangedPlayerPositionEvent;
import racing.watcher.events.StartedRacingEvent;

import java.util.ArrayList;
import java.util.List;

public class Stage {

	private List<RacingCar> players;

	private RacingWatcher watcher;

	private int initialRound;

	private int remainingRound;

	private Stage(StageBuilder stageBuilder){
		this.initialRound = this.remainingRound = stageBuilder.round;
		this.players = stageBuilder.players;
		this.watcher = stageBuilder.watcher;

	}

	public int getCountOfPlayers() {
		return players.size();
	}

	public int getRemainingRounds() {
		return remainingRound;
	}

	public void playRound() {

		if (remainingRound == 0){
			throw new PlayOverException("레이싱이 종료되었습니다.");
		}

		if(remainingRound == initialRound){
			watcher.handle(new StartedRacingEvent());
		}

		for(RacingCar car : players){
			car.accelerate(5);
		}

		if(watcher != null){
			ArrayList currentPositions = new ArrayList<>();
			for(RacingCar car : players){
				currentPositions.add(car.getMileage());
			}

			watcher.handle(new ChangedPlayerPositionEvent(currentPositions));
		}

		remainingRound -= 1;
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

		private List<RacingCar> players;

		private RacingWatcher watcher;

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

		public void watcher(RacingWatcher watcher) {
			this.watcher = watcher;
		}
	}
}
