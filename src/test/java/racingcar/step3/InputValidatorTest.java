package racingcar.step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

	private InputValidator inputValidator;

	@BeforeEach
	void setUp() {
		inputValidator = new InputValidator();
	}

	@DisplayName("입력된 값이 수가 아닐 때 예외 발생")
	@Test
	void validateNotNumberInputTest() {
		assertThatThrownBy(() -> inputValidator.isNumber("하나"))
			.isExactlyInstanceOf(NumberFormatException.class);
	}

	@DisplayName("입력된 값이 0이하의 수일 때 예외 발생")
	@Test
	void validatePositiveInputTest() {
		assertThatThrownBy(() -> inputValidator.isNegative("-1"))
			.isExactlyInstanceOf(NumberFormatException.class);
	}
}
