package study.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	private final RacingGame racingGame = new RacingGame();
	private String[] names;

	@BeforeEach
	void setUp() {
		names = racingGame.split("car1,car2,car3");
	}

	@DisplayName("자동차 이름을 쉼표(,)를 기준으로 분리한다.")
	@Test
	void Given_CarNamesWithSeparator_Then_ReturnCarName() {
		assertThat(names).contains("car1", "car2", "car3");
	}

	@DisplayName("쉼표로 분리된 이름 개수와 참가자의 사이즈는 같다.")
	@Test
	void Given_CarNames_Then_RegisterParticipants() {
		Cars result = racingGame.registerParticipants(names);
		assertThat(result.size()).isEqualTo(names.length);
	}
}