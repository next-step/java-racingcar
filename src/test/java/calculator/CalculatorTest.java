package calculator;

import static org.assertj.core.api.Assertions.*;

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
	void userInputIsEmpty(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력값이 존재하지 않습니다.");
	}

	@DisplayName("2. 계산식이 없거나, 옳바르게 종료되지 않은 경우 ")
	@ParameterizedTest
	@ValueSource(strings = {"1 + ", "5 + 2 + ", "2 + 2 + 1 +"})
	void userInputIsInvalidPattern(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("계산식이 옳바르지 않습니다. 계산식이 없거나 계산식이 옳바르게 종료되지 않았습니다.");
	}


}