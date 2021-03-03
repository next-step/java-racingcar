package study;

import static camp.nextstep.edu.util.StringUtil.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.entity.Operation;
import camp.nextstep.edu.exception.UserException;
import camp.nextstep.edu.module.Calculator;

public class StringCaculatorTest {

	@ParameterizedTest
	@DisplayName("더하기 연산")
	@CsvSource(value = {"21 + 1=22"}, delimiter = '=')
	void plus(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		for (String word : inputs) {
			if (isNumeric(word)) {
				result += Integer.parseInt(word);
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("빼기 연산")
	@CsvSource(value = {"1 - 1=0"}, delimiter = '=')
	void minus(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		for (String word : inputs) {
			if (isNumeric(word)) {
				result -= Integer.parseInt(word);
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("나누기 연산")
	@CsvSource(value = {"21 / 2=10"}, delimiter = '=')
	void divide(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		for (String word : inputs) {
			if (isNumeric(word)) {
				result /= Integer.parseInt(word);
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("곱하기 연산")
	@CsvSource(value = {"1 * 1=1"}, delimiter = '=')
	void multiply(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		for (String word : inputs) {
			if (isNumeric(word)) {
				result *= Integer.parseInt(word);
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("0번째가 숫자가아닌경우")
	@ValueSource(strings = {"= 2 + 3"})
	void numeric_exception_test(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
					if (!isNumeric(inputSplitedByBlank.get(0))) {
						throw new UserException();
					}
				}).withMessageMatching("정상적인 사용자 값이 아닙니다.");

	}

	@Test
	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
	void illegalArgumentException_test() {
		List<String> list = new ArrayList<>();

		list.add("");
		list.add(null);

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> list.forEach(word -> {
					if (word == null || word.equals("")) {
						throw new UserException();
					}
				}))
				.withMessageMatching("정상적인 사용자 값이 아닙니다.");
	}

	@ParameterizedTest
	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	@ValueSource(strings = {",", ":"})
	void 사칙연산이_아닌경우_IllegalArgumentException(String input) {
		List<String> list = Arrays.asList(input.split(" "));
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					list.forEach(word -> {
						if (!Operation.isOperation(word)) {
							throw new UserException();
						}
					});
				}).withMessageMatching("정상적인 사용자 값이 아닙니다.");
	}

	@ParameterizedTest
	@DisplayName("Operation 성공케이스")
	@ValueSource(strings = {"+", "-", "/", "*"})
	void Operation_성공(String input) {
		assertThat(Operation.getResult(1, 1, input))
				.isGreaterThanOrEqualTo(0);
	}

	@ParameterizedTest
	@DisplayName("Opeartion 실패케이스")
	@ValueSource(strings = {"%", "!", "~"})
	void Opeartion_exception(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Operation.getResult(1, 1, input);
				}).withMessageMatching("정상적인 사용자 값이 아닙니다.");
	}

	@ParameterizedTest
	@DisplayName("isOperation check")
	@CsvSource(value = {"/:true", "+:true", "-:true", "*:true", "%:false", "!:false"}, delimiter = ':')
	void Operation_isOperation_check(String input, boolean expected) {
		assertThat(Operation.isOperation(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("전체 사칙연산")
	@CsvSource(value = {"22 + 1 / 11 * 5=10", "2 + 1 / 5 * 3=0"}, delimiter = '=')
	void operation(String input, int expected) {
		int result = new Calculator().getResult(input);
		assertThat(result).isEqualTo(expected);
	}
}
