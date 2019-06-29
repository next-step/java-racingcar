package racing.view;

import racing.vo.PlayerRecord;

import java.util.List;

public interface RacingMonitorView {

	void renderStart(String message);

	void renderRound(List<PlayerRecord> records);

	void renderFinish(List<PlayerRecord> records);
}
