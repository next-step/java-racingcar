package nextstep.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarGameTest {

	@ParameterizedTest
	@DisplayName("자동차 경주 게임 테스트")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	public void startTest(int carNumber) {
		int tryNumber = 5;
		RacingCarGame.startGame(carNumber, tryNumber);
	}
}
