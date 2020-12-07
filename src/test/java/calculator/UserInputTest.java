package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.model.CalculatorType;
import calculator.model.CalculatorVaild;

class UserInputTest {

	@Test
	@DisplayName("유저 전체 입력 테스트")
	void userInputTest() {

		String userInput = "2 + 3 * 4 / 2 / 56 + 45646 * 6  ";

		assertThatIllegalArgumentException().isThrownBy(() -> CalculatorVaild.validCalculatorString(userInput));
	}

	@ParameterizedTest
	@ValueSource(strings = {"    ", "", "테 스 트"})
	@DisplayName("빈 문자열 테스트")
	void bankTest(String inputStr) {

		assertTrue(CalculatorVaild.isBank(inputStr));
	}

	@ParameterizedTest
	@ValueSource(strings = {"2", "333", "-7", "Apple"})
	@DisplayName("숫자 입력 테스트")
	void numberTest(String inputNumber) {

		assertTrue(CalculatorVaild.isNumber(inputNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = {"+", "*", "/", "-"})
	@DisplayName("사칙연산 부호 테스트")
	void operatorTest(String inputOperator) {

		assertThatIllegalArgumentException().isThrownBy(() -> CalculatorType.getOperator(inputOperator));
	}
}
