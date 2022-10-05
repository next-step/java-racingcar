package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step3_4.view.InputValidator;

class InputValidatorTest {

	private InputValidator inputValidator;

	@BeforeEach
	void setUp() {
		inputValidator = new InputValidator();
	}

	@DisplayName("입력된 값이 0이하의 수일 때 예외 발생")
	@ParameterizedTest
	@ValueSource(ints = {0, -1})
	void validatePositiveInputTest(int input) {
		assertThatThrownBy(() -> inputValidator.isZeroOrNegative(input))
			.isExactlyInstanceOf(NumberFormatException.class);
	}

	@DisplayName("입력된 값이 빈 문자열일 경우 예외 발생")
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", " "})
	void validateBlankInputTest(String input) {
		assertThatThrownBy(() -> inputValidator.isBlank(input))
			.isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
