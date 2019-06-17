package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import racing.exception.PlayOverException;
import racing.player.Player;
import racing.watcher.RacingWatcher;
import racing.watcher.events.ChangedPlayerPositionEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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
			builder.addToEntry(mock(Player.class));
		}

		// Action
		Stage stage = builder.build();

		// Assertion
		assertThat(stage.getCountOfPlayers()).isEqualTo(entrySize);
		assertThat(stage.getRemainingRounds()).isEqualTo(round);
	}

	@Test
	@DisplayName("게임 진행관련 기본기능 테스트")
	void playRound(){

		// Arrange
		Stage.StageBuilder builder = Stage.builder(2, 5);

		Player player1 = mock(Player.class);
		builder.addToEntry(player1);

		Player player2 = mock(Player.class);
		builder.addToEntry(player2);

		Stage stage = builder.build();

		// Action
		stage.playRound(); // 1회 수행

		// Assertion
		assertThat(stage.getRemainingRounds()).isEqualTo(4);
		verify(player1, times(1)).drive();
		verify(player2, times(1)).drive();
	}

	@Test
	@DisplayName("지정된 라운드를 초과하는 게임 수행 테스트")
	void outOfRound(){
		// Arrange
		int roundLimit = 5;
		Stage.StageBuilder builder = Stage.builder(1, roundLimit);
		builder.addToEntry(mock(Player.class));
		Stage stage = builder.build();

		// Action & Assertion
		assertThatExceptionOfType(PlayOverException.class)
				.isThrownBy(() -> {
					for(int i = 0; i < (roundLimit + 1); i++){
						stage.playRound();
					}
				});

	}

	@Test
	@DisplayName("게임 중계 시스템 적용 테스트")
	void updateWatcher(){
		// Arrange
		int roundLimit = 5;
		Stage.StageBuilder builder = Stage.builder(2, roundLimit);

		// add to racer
		builder.addToEntry(mock(Player.class));
		builder.addToEntry(mock(Player.class));

		// set watcher
		RacingWatcher watcher = mock(RacingWatcher.class);
		builder.watcher(watcher);

		Stage stage = builder.build();

		// Action
		stage.playRound();

		// Assertion (플레이어 위치변경 이벤트에 전체 참가자 숫자만큼 정보가 전달되는지 확인)
		ArgumentCaptor<ChangedPlayerPositionEvent> argument = ArgumentCaptor.forClass(ChangedPlayerPositionEvent.class);
		verify(watcher, times(1)).handle(argument.capture());
		assertThat(argument.getValue().getPositions().size()).isEqualTo(2);


	}

}