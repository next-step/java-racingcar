package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/02
 * @description : 계산 테스트
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@Order(1)
	@DisplayName("1. 입력값이 없는경우")
	@ParameterizedTest
	@ValueSource(strings = {"", " ", "    "})
	void userInputIsEmpty(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("입력값이 존재하지 않습니다.");
	}

	@Order(2)
	@DisplayName("2. 계산식이 없거나, 옳바르게 종료되지 않은 경우 ")
	@ParameterizedTest
	@ValueSource(strings = {"1 + ", "5 + 2 + ", "2 + 2 + 1 +"})
	void userInputIsInvalidPatternOnLength(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("계산식이 옳바르지 않습니다. 계산식이 없거나 계산식이 옳바르게 종료되지 않았습니다.");
	}

	@Order(3)
	@DisplayName("3. 계산식의 숫자와 연산자의 조합이 옳바르지 않습니다.(홀수 숫자체크)")
	@ParameterizedTest
	@ValueSource(strings = {"+ + 3 + 5", "3 + + + 2"})
	void userInputIsInvalidPatternOnNumberPosition(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("계산식이 옳바르지 않습니다. 숫자의 위치가 옳바르지 않습니다.");
	}

	@Order(4)
	@DisplayName("4. 계산식의 숫자와 연산자의 조합이 옳바르지 않습니다.(짝수 연산자체크)")
	@ParameterizedTest
	@ValueSource(strings = {"1 3 5", "1 # 5", "2 ? 9 + 5"})
	void userInputIsInvalidPatternOnOperatorPosition(String arg) {
		assertThatThrownBy(() -> {
			calculator.calculate(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("허용된 연산자가 아닙니다.");
	}
}