package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

	RaceGameController gameProcessor;
	OutputView outputView;

	@BeforeEach
	void setUp() {
		InputValue inputValue = new InputValue("1,2,3,4", 5);
		gameProcessor = new RaceGameController(inputValue, new SimpleMovePolicy());
		outputView = new OutputView(gameProcessor);
	}

	@DisplayName("경주 게임 시도 횟수만큼 결과 메시지가 변하는지 확인")
	@Test
	void 경주게임_결과메세지_TEST() {
		gameProcessor.start();
		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(outputView.getGameResultMessage()).isEqualTo(expected);
	}
}
