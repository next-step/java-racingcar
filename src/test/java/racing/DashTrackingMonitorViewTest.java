package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.MessagePrinter;
import racing.view.DashTrackingMonitorView;
import racing.view.events.ChangedPlayerPositionEvent;
import racing.view.events.StartedRacingEvent;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DashTrackingMonitorViewTest {

	@Test
	@DisplayName("게임시작 이벤트 핸들링 테스트")
	void startedPlayEventHandling(){

		// Arrange
		MessagePrinter mockPrinter = mock(MessagePrinter.class);
		DashTrackingMonitorView watcher = new DashTrackingMonitorView(mockPrinter);


		// Action
		watcher.handle(new StartedRacingEvent());

		// Assertion
		verify(mockPrinter).printMessage(StartedRacingEvent.DEFAULT_START_MESSAGE);
	}

	@Test
	@DisplayName("플레이어 위치변경 이벤트 핸들링 테스트")
	void changedPositionEventHandling(){

		// Arrange
		StringBuilder verifyMessage = new StringBuilder();
		DashTrackingMonitorView watcher = new DashTrackingMonitorView((message) -> {
			verifyMessage.append(message);
			verifyMessage.append("/");
		});

		List<Integer> positions = new ArrayList<>();
		// 0, 1 모두 대시("-") 1개 출력
		positions.add(0); // -
		positions.add(1); // -

		// 2 이상은 개수만큼 출력
		positions.add(2); // --

		// Action
		watcher.handle(new ChangedPlayerPositionEvent(positions));

		// Assertion
		assertThat(verifyMessage.toString()).isEqualTo("-/-/--/" + DashTrackingMonitorView.EMPTY_NEW_LINE + "/");
	}
}