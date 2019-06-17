package racing;

import racing.exception.PlayOverException;
import racing.player.Player;
import racing.watcher.RacingWatcher;
import racing.watcher.events.ChangedPlayerPositionEvent;
import racing.watcher.events.StartedRacingEvent;

import java.util.ArrayList;
import java.util.List;

public class Stage {

	private List<Player> players;

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

		ArrayList currentPositions = new ArrayList<>();
		for(Player player : players){
			player.drive();
			currentPositions.add(player.getPosition());
		}

		if(watcher != null){
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

		private List<Player> players;

		private RacingWatcher watcher;

		private StageBuilder(int entrySize, int round) {
			this.entrySize = entrySize;
			this.round = round;
			players = new ArrayList<>();
		}

		public Stage build() {
			return new Stage(this);
		}

		public void addToEntry(Player racingCar) {
			players.add(racingCar);
		}

		public void watcher(RacingWatcher watcher) {
			this.watcher = watcher;
		}
	}
}
