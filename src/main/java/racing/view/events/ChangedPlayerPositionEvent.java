package racing.view.events;

import racing.vo.RacingRecord;

import java.util.List;

public class ChangedPlayerPositionEvent implements RacingEvent {

	private List<RacingRecord> records;

	public ChangedPlayerPositionEvent(List<RacingRecord> records){
		this.records = records;
	}

	public List<RacingRecord> getPositions(){
		return records;
	}
}
