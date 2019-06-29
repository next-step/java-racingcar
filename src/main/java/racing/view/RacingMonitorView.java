package racing.view;

import racing.vo.RacingRecord;

import java.util.List;

public interface RacingMonitorView {

	void renderStart(String message);

	void renderRound(List<RacingRecord> records);

	void renderFinish(List<RacingRecord> records);
}
