package nextstep.step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarControllerTest {
	private RacingCarController underTest = new RacingCarController();

	@ParameterizedTest
	@DisplayName("자동차 경주 게임 테스트")
	@ValueSource(strings = {"adel,angus,joy,ruby"})
	public void startTest(String carName) {
		int tryNumber = 5;
		underTest.startGame(carName, tryNumber);
	}

	@Test
	@DisplayName("시도횟수 입력값 체크")
	public void validateInputTryValueTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validate(Arrays.asList("adel", "joy"), -5))
				.withMessage("시도 횟수는 양수이어야 합니다.");
	}

	@Test
	@DisplayName("자동차명 입력값 체크")
	public void validateInputNameValueTest() {
		Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> underTest.validate(new ArrayList<>(), 5))
				.withMessage("자동차 이름은 필수 입력 입니다.");
	}

	@Test
	@DisplayName("자동차 이름을 가져온다.")
	public void getCarNamesTest() {
		List<String> carNames = underTest.getCarNames("adel,joy,ruby,angus,shawn");
		assertThat(carNames.size()).isEqualTo(5);
		assertTrue(carNames.contains("adel"));
		assertTrue(carNames.contains("joy"));
		assertTrue(carNames.contains("ruby"));
		assertTrue(carNames.contains("angus"));
		assertTrue(carNames.contains("shawn"));
	}
}
