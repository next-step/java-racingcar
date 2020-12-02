package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/02
 * @description : 계산 테스트
 **/
class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@DisplayName("1. 입력값이 없는경우")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "    "})
	void userInputValid(String arg) {
		assertThrows(IllegalArgumentException.class, () -> {
			calculator.calculate(arg);
		});
	}
}