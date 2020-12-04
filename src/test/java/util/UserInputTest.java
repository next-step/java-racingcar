package util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTest {

	@ParameterizedTest
	@ValueSource(strings = {"    ", "", "테 스 트"})
	@DisplayName("빈 문자열 테스트")
	void bankTest(String inputStr) {

		assertTrue(UserInput.isBank(inputStr));
	}

	@ParameterizedTest
	@ValueSource(strings = {"2", "333", "-7", "Apple"})
	@DisplayName("숫자 입력 테스트")
	void numberTest(String inputNumber) {

		assertTrue(UserInput.isNumber(inputNumber));
	}

	@ParameterizedTest
	@ValueSource(strings = {"+", "*", "/", "-", "%"})
	@DisplayName("사칙연산 부호 테스트")
	void operatorTest(String inputOperator) {

		assertTrue(UserInput.isOperator(inputOperator));
	}
}
