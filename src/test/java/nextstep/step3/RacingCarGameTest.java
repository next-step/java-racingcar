package nextstep.step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarGameTest {

	@ParameterizedTest
	@DisplayName("자동차 경주 게임 테스트")
	@ValueSource(strings = {"adel,angus,joy,ruby"})
	public void startTest(String carName) {
		int tryNumber = 5;
		RacingCarGame.startGame(carName, tryNumber);
	}

	@Test
	@DisplayName("입력값 체크")
	public void validateInputValueTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> RacingCarGame.startGame("adel", -5))
				.withMessage("시도 횟수는 양수이어야 합니다.");
	}
}
