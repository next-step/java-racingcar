package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;

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
		assertThat(stage.remainingRounds()).isEqualTo(round);
	}

	@DisplayName("게임 진행관련 기능 테스트")
	@Test
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
		assertThat(stage.remainingRounds()).isEqualTo(4);
	}

}