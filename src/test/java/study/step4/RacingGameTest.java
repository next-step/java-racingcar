package study.step4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

	private final RacingGame racingGame = new RacingGame();

	@DisplayName("자동차 이름을 쉼표(,)를 기준으로 분리한다.")
	@Test
	void Given_CarNamesWithSeparator_Then_ReturnCarName() {
		String[] result = racingGame.splitCarNames("car1,car2,car3");
		assertThat(result).contains("car1", "car2", "car3");
	}

	@DisplayName("random 값이 4 이상인 경우 true 를 반환한다")
	@Test
	void Given_MoreThen4_Then_ReturnTrue() {
		boolean result = racingGame.isGoForward(4);
		assertThat(result).isTrue();
	}

	@DisplayName("random 값이 4 미만인 경우 false 를 반환한다")
	@Test
	void Given_Under4_Then_ReturnFalse() {
		boolean result = racingGame.isGoForward(3);
		assertThat(result).isFalse();
	}
}