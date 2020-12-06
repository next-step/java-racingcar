package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

	RaceGameProcessor gameProcessor;
	OutputView outputView;

	@BeforeEach
	void setUp() {
		InputValue inputValue = new InputValue(5, 5);
		gameProcessor = new RaceGameProcessor(inputValue, new SimpleMovePolicy());
		outputView = new OutputView(gameProcessor.getGameSubject());
	}

	@DisplayName("경주 게임 시도 횟수만큼 결과 메시지가 변하는지 확인")
	@Test
	void 경주게임_결과메세지_TEST() {
		gameProcessor.running();
		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(outputView.getGameResultMessage()).isEqualTo(expected);
	}
}
