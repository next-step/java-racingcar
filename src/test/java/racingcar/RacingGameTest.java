package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void 레이싱_게임을_초기화하면_입력받은_숫자만큼_차량이_초기화된다(int num) {
		RacingGame game = new RacingGame(num);
		Assertions.assertThat(game.getCars().size()).isEqualTo(num);
	}
}
