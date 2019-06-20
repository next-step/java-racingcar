package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.MessagePrinter;
import racing.view.DashTrackingMonitorView;
import racing.view.events.ChangedPlayerPositionEvent;
import racing.view.events.FinishStageEvent;
import racing.view.events.StartedRacingEvent;
import racing.vo.RacingRecord;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DashTrackingMonitorViewTest {

	@Test
	@DisplayName("게임시작 이벤트 핸들링 테스트")
	void startedPlayEventHandling(){

		// Arrange
		List<String> messagesFromView = new ArrayList<>();
		DashTrackingMonitorView watcher = new DashTrackingMonitorView((message) -> {
			messagesFromView.add(message);
		});

		// Action
		watcher.handle(new StartedRacingEvent());

		// Assertion
		assertThat(messagesFromView.size()).isEqualTo(1);
		assertThat(messagesFromView.get(0)).isEqualTo(StartedRacingEvent.DEFAULT_START_MESSAGE);
	}

	@Test
	@DisplayName("플레이어 위치변경 이벤트 핸들링 테스트")
	void changedPositionEventHandling(){

		// Arrange
		List<String> messagesFromView = new ArrayList<>();
		DashTrackingMonitorView watcher = new DashTrackingMonitorView((message) -> {
			messagesFromView.add(message);
		});

		List<RacingRecord> records = new ArrayList<>();
		records.add(new RacingRecord("playerA", 0));
		records.add(new RacingRecord("playerB", 1));
		records.add(new RacingRecord("playerC", 2));

		// Action
		watcher.handle(new ChangedPlayerPositionEvent(records));

		// Assertion
		assertThat(messagesFromView.get(0)).isEqualTo("playerA:-");	// 0, 1 모두 대시("-") 1개 출력
		assertThat(messagesFromView.get(1)).isEqualTo("playerB:-");
		assertThat(messagesFromView.get(2)).isEqualTo("playerC:--");	// 2 이상은 개수만큼 출력
		assertThat(messagesFromView.size()).isEqualTo(4); // 마지막 공백라인으로 플레이어 수 + 1 개 메세지 전달
	}

	@Test
	@DisplayName("게임종료 이벤트 핸들링 테스트")
	void finishStageEventHandling(){

		// Arrange
		List<String> messagesFromView = new ArrayList<>();
		DashTrackingMonitorView watcher = new DashTrackingMonitorView((message) -> {
			messagesFromView.add(message);
		});

		List<RacingRecord> records = new ArrayList<>();
		records.add(new RacingRecord("playerA", 5));	// position 은 사용하지 않기 때문에 의미 없음

		// Action
		watcher.handle(new FinishStageEvent(records));

		// Assertion
		assertThat(messagesFromView.get(0)).isEqualTo("playerA가 최종 우승했습니다.");
	}


}