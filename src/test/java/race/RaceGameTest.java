package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class RaceGameTest {

	GameSubject gameSubject;
	OutputView outputView;

	@BeforeEach
	void setUp() {
		outputView = new OutputView();
		gameSubject = new RaceGame(5, outputView);
	}

	@DisplayName("경주 게임 시도 횟수만큼 결과 메시지가 변하는지 확인")
	@Test
	void 경주게임_결과메세지_TEST() {
		IntStream.rangeClosed(1, 5).forEach(i -> {
			gameSubject.notifyObserver();
		});
		String expected = "-----\n" +
			"-----\n" +
			"-----\n" +
			"-----\n" +
			"-----";
		assertThat(outputView.getGameResultMessage()).isEqualTo(expected);

	}
}
