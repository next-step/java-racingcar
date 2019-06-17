package racing.watcher;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.ConsolePrinter;
import racing.watcher.events.StartedRacingEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DashTrackingWatcherTest {

	@Test
	@DisplayName("게임시작 이벤트 핸들링 테스트")
	void startedPlayEventHandling(){

		// Arrange
		ConsolePrinter mockPrinter = mock(ConsolePrinter.class);
		DashTrackingWatcher watcher = new DashTrackingWatcher(mockPrinter);


		// Action
		watcher.handle(new StartedRacingEvent());

		// Assertion
		verify(mockPrinter).printMessage("실행 결과");
	}

}