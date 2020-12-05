package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameProcessorTest {

	@DisplayName("InputView를 주입받은 GameProcessor running 결과가 옳바른지 테스트")
	@Test
	void GameProcessor_Running_TEST() {
		InputView inputView = new InputView(5, 5);
		GameProcessor gameProcessor = GameProcessor.ofInputView(inputView, new SimpleMovePolicy());
		OutputView outputView = new OutputView(gameProcessor.getGameSubject());
		gameProcessor.running();

		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(outputView.getGameResultMessage()).isEqualTo(expected);

	}
}
