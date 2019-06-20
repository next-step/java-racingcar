package racing.domain;

import racing.exception.OutOfEntryException;
import racing.exception.PlayOverException;
import racing.view.RacingMonitorView;
import racing.view.events.ChangedPlayerPositionEvent;
import racing.view.events.FinishStageEvent;
import racing.view.events.RacingEvent;
import racing.view.events.StartedRacingEvent;
import racing.vo.EntryItem;

import java.util.ArrayList;
import java.util.List;

public class Stage {

	private static final int END_OF_ROUND = 0;

	private Entry entry;

	private RacingMonitorView monitorView;

	private int remainingRound;

	private Stage(StageBuilder stageBuilder){

		this.entry = new Entry(stageBuilder.items);
		this.remainingRound = stageBuilder.round;
		this.monitorView = stageBuilder.monitorView;
	}

	public int getCountOfPlayers() {
		return entry.size();
	}


	public int getRemainingRounds() {
		return remainingRound;
	}

	public void play() {

		if (remainingRound == END_OF_ROUND){
			throw new PlayOverException("레이싱이 종료되었습니다.");
		}

		this.emitEvent(new StartedRacingEvent());

		do{
			this.playRound();
		}while (remainingRound > 0);

		this.emitEvent(new FinishStageEvent(entry.getWinners()));
	}

	private void playRound() {

		this.emitEvent(new ChangedPlayerPositionEvent(entry.drive()));
		remainingRound -= 1;
	}

	private void emitEvent(RacingEvent event){

		if(monitorView != null){
			monitorView.handle(event);
		}
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

		private RacingMonitorView monitorView;

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

		public void view(RacingMonitorView watcher) {
			this.monitorView = watcher;
		}
	}
}
