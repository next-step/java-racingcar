package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import racing.car.RacingCar;
import racing.exception.PlayOverException;
import racing.watcher.RacingWatcher;
import racing.watcher.events.ChangedPlayerPositionEvent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
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
			builder.addToEntry(mock(RacingCar.class));
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

		RacingCar car1 = mock(RacingCar.class);
		builder.addToEntry(car1);

		RacingCar car2 = mock(RacingCar.class);
		builder.addToEntry(car2);

		Stage stage = builder.build();

		// Action
		stage.playRound(); // 1회 수행

		// Assertion
		assertThat(stage.getRemainingRounds()).isEqualTo(4);
		verify(car1, times(1)).accelerate(anyInt());
		verify(car2, times(1)).accelerate(anyInt());
	}

	@Test
	@DisplayName("지정된 라운드를 초과하는 게임 수행 테스트")
	void outOfRound(){
		// Arrange
		int roundLimit = 5;
		Stage.StageBuilder builder = Stage.builder(1, roundLimit);
		builder.addToEntry(mock(RacingCar.class));
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
		builder.addToEntry(mock(RacingCar.class));
		builder.addToEntry(mock(RacingCar.class));

		// set watcher
		RacingWatcher watcher = mock(RacingWatcher.class);
		builder.watcher(watcher);

		Stage stage = builder.build();

		// Action
		stage.playRound();

		// Assertion
		ArgumentCaptor<ChangedPlayerPositionEvent> argument = ArgumentCaptor.forClass(ChangedPlayerPositionEvent.class);
		verify(watcher, times(1)).handle(argument.capture());
		assertThat(argument.getValue().getPositions().size()).isEqualTo(2);


	}

}