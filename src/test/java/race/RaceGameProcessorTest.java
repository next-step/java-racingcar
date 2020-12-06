package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RaceGameProcessorTest {

	@DisplayName("InputView를 주입받은 RaceGameProcessor running 결과가 옳바른지 테스트")
	@Test
	void GameProcessor_Running_TEST() {
		InputView inputView = new InputView(5, 5);
		RaceGameProcessor gameProcessor = RaceGameProcessor.ofInputView(inputView, new SimpleMovePolicy());
		gameProcessor.running();

		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(gameProcessor.getGameSubject().createGameResultMessage()).isEqualTo(expected);
	}
}
