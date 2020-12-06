package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceGameProcessorTest {

	@DisplayName("InputView를 주입받은 RaceGameProcessor running 결과가 옳바른지 테스트")
	@Test
	void GameProcessor_Running_TEST() {
		InputValue inputValue = new InputValue(5, 5);
		RaceGameProcessor gameProcessor = new RaceGameProcessor(inputValue, new SimpleMovePolicy());
		gameProcessor.running();

		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(gameProcessor.getGameSubject().createGameResultMessage()).isEqualTo(expected);
	}


	@DisplayName("경주할 자동차 이름을 부여하고 결과 메세지에 이름을 추가한다.")
	@Test
	void GameProcessor_findWinner_TEST() {
		InputValue inputValue = new InputValue("pobi,crong,honux", 5);
		RaceGameProcessor gameProcessor = new RaceGameProcessor(inputValue, new SimpleMovePolicy());
		gameProcessor.running();

		String expected = "pobi : -----\n" +
			"crong : -----\n" +
			"honux : -----";

		assertThat(gameProcessor.getGameSubject().createGameResultMessage()).isEqualTo(expected);
	}
}

