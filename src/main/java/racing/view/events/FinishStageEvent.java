package racing.view.events;

import racing.vo.RacingRecord;

import java.util.List;

public class FinishStageEvent implements RacingEvent{

	private List<RacingRecord> winners;

	public FinishStageEvent(List<RacingRecord> winners){
		this.winners = winners;
	}

	public List<RacingRecord> getWinners(){
		return winners;
	}

}
