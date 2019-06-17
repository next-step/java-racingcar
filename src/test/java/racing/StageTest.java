package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StageTest {

	@DisplayName("게임 생성 테스트")
	@ParameterizedTest
	@CsvSource({"1,5", "3,2"})
	void createGame(int entry, int round){

		Stage.StageBuilder builder = Stage.builder(entry, round);


		Stage stage = builder.build();
		assertThat(stage.getCountOfPlayers()).isEqualTo(entry);
		assertThat(stage.remainingRounds()).isEqualTo(round);
	}

}