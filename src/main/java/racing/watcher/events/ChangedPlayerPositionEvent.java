package racing.watcher.events;

import java.util.List;

public class ChangedPlayerPositionEvent implements RacingEvent {

	private List<Integer> positions;

	public ChangedPlayerPositionEvent(List<Integer> positions){
		this.positions = positions;
	}

	public List<Integer> getPositions(){
		return positions;
	}
}
