package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	@DisplayName("입력값 공백 제거 및 숫자/연산자 분리")
	void splitNumberAndOperatorTest() {
		String data = "2 + 3 * 4 / 2";
		String[] splitData = calculator.splitNumberAndOperator(data);

		assertThat(splitData.length).isEqualTo(7);
		assertThat(splitData).containsExactly("2", "+", "3", "*", "4", "/", "2");
	}

	@Test
	@DisplayName("입력값 검증 : 공백 및 Null 체크")
	void validateInputEmptyOrNullTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull("");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull(" ");
		});

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputEmptyOrNull(null);
		});
	}

	@Test
	@DisplayName("입력값 검증 : 사칙 연산 기호 체크")
	void validateInputOperatorTest() {
		String[] data = {"1", "&", "5", "_", "8"};

		assertThatIllegalArgumentException().isThrownBy(() -> {
			calculator.validateInputOperator(data);
		});
	}

	@DisplayName("덧셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,5:6", "3,7:10", "51,4:55"}, delimiter = ':')
	void addTest(String input, String expected) {
		String[] data = input.split(",");
		Integer firstNumber = Integer.valueOf(data[0]);
		Integer secondNumber = Integer.valueOf(data[1]);
		Integer expectedNumber = Integer.valueOf(expected);

		assertThat(calculator.add(firstNumber, secondNumber)).isEqualTo(expectedNumber);
	}

	@DisplayName("뺄셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,5:-4", "7,3:4", "51,4:47"}, delimiter = ':')
	void subtractTest(String input, int expectedNumber) {
		String[] data = input.split(",");
		int firstNumber = Integer.valueOf(data[0]);
		int secondNumber = Integer.valueOf(data[1]);

		assertThat(calculator.subtract(firstNumber, secondNumber)).isEqualTo(expectedNumber);
	}

	@DisplayName("곱셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1,5:5", "7,3:21", "11,4:44"}, delimiter = ':')
	void multiplyTest(String input, int expectedNumber) {
		String[] data = input.split(",");
		int firstNumber = Integer.valueOf(data[0]);
		int secondNumber = Integer.valueOf(data[1]);

		assertThat(calculator.multiply(firstNumber, secondNumber)).isEqualTo(expectedNumber);
	}

	@DisplayName("나눗셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5,5:1", "21,3:7", "15,3:5"}, delimiter = ':')
	void divideTest(String input, int expectedNumber) {
		String[] data = input.split(",");
		int firstNumber = Integer.valueOf(data[0]);
		int secondNumber = Integer.valueOf(data[1]);

		assertThat(calculator.divide(firstNumber, secondNumber)).isEqualTo(expectedNumber);
	}

	@DisplayName("계산기 테스트")
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2:10", "5 * 3:15", "3 - 8 + 15 / 2 / 5 * 30:30"}, delimiter = ':')
	void calculateTest(String input, int expected) {
		String[] splitData = calculator.splitNumberAndOperator(input);
		assertThat(calculator.calculate(splitData)).isEqualTo(expected);
	}

	@DisplayName("String#tim,isEmpty Test")
	@ParameterizedTest
	@ValueSource(strings = {"", " "})
	void isBlankTest(String input) {
		assertThat(input.trim().isEmpty()).isEqualTo(true);
	}
}
