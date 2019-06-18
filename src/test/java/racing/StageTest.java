package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import racing.domain.Player;
import racing.domain.RacingCar;
import racing.domain.Stage;
import racing.view.RacingMonitorView;
import racing.view.events.ChangedPlayerPositionEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class StageTest {

	@DisplayName("게임 생성 테스트")
	@ParameterizedTest
	@CsvSource({"1,5", "3,2"})
	void createGame(int entrySize, int round){

		// Arrange
		Stage.StageBuilder builder = Stage.builder(entrySize, round);

		for(int i = 0; i < entrySize; i++) {
			builder.addToEntry(new Player(new RacingCar()));
		}

		// Action
		Stage stage = builder.build();

		// Assertion
		assertThat(stage.getCountOfPlayers()).isEqualTo(entrySize);
		assertThat(stage.getRemainingRounds()).isEqualTo(round);
	}


	@Test
	@DisplayName("게임 중계 시스템 적용 테스트")
	void updateWatcher(){

		// Arrange
		int roundLimit = 5;
		Stage.StageBuilder builder = Stage.builder(2, roundLimit);
		builder.addToEntry(new Player(new RacingCar()));
		builder.addToEntry(new Player(new RacingCar()));

		RacingMonitorView view = mock(RacingMonitorView.class);
		builder.view(view);

		Stage stage = builder.build();

		// Action
		stage.play();

		// Assertion (플레이어 위치변경 이벤트에 전체 참가자 숫자만큼 정보가 전달되는지 확인)
		ArgumentCaptor<ChangedPlayerPositionEvent> argument = ArgumentCaptor.forClass(ChangedPlayerPositionEvent.class);
		verify(view, times(5)).handle(argument.capture());


	}

}