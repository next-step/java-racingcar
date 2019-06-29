package racing.domain;

import racing.exception.OutOfEntryException;
import racing.exception.PlayOverException;
import racing.vo.RacingRecord;

import java.util.ArrayList;
import java.util.List;


public class Stage {

	private static final int END_OF_ROUND = 0;

	private Entry entry;

	private int remainingRound;

	private Stage(StageBuilder stageBuilder){

		this.entry = new Entry(stageBuilder.items);
		this.remainingRound = stageBuilder.round;
	}

	public int getCountOfPlayers() {
		return entry.size();
	}


	public int getRemainingRounds() {
		return remainingRound;
	}

	public List<RacingRecord> play() {

		if (remainingRound == END_OF_ROUND){
			throw new PlayOverException("레이싱이 종료되었습니다.");
		}

		remainingRound -= 1;

//		this.emitEvent(new FinishStageEvent(entry.getWinners()));
		return entry.drive();
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

		private List<EntryItem> items;

		private StageBuilder(int entrySize, int round) {

			this.entrySize = entrySize;
			this.round = round;
			items = new ArrayList<>();
		}

		public Stage build() {
			return new Stage(this);
		}

		public void addToEntry(String name, RacingCar racingCar) {

			if(items.size() == entrySize){
				throw new OutOfEntryException();
			}

			items.add(new EntryItem(name, racingCar));
		}
	}
}
