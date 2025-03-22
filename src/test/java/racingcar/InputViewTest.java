package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.view.InputView;

class InputViewTest {
	@Test
	@DisplayName("1 이상의 정수이면 예외가 발생하지 않는다.")
	void validateNaturalNumberTest_GEOne() {
		// given
		int validInteger = 5;

		// when & then
		Assertions.assertThatCode(() -> InputView.validateNaturalNumber(validInteger))
			.doesNotThrowAnyException();
	}

	@Test
	@DisplayName("1 보다 작은 정수이면 예외가 발생한다.")
	void validateNaturalNumberTest_LTOne() {
		// given
		int invalidInput = 0;

		// when & then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> InputView.validateNaturalNumber(invalidInput))
			.withMessageContaining("1 이상의 정수만 입력할 수 있습니다.");
	}

}
