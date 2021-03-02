package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import camp.nextstep.edu.entity.Operation;

public class StringCaculatorTest {

	private static final String numericRegex = "^[0-9]+";
	private static final String operationRegex = "[-*/+]";

	@ParameterizedTest
	@DisplayName("더하기 연산")
	@CsvSource(value = {"21 + 1=22"}, delimiter = '=')
	void plus(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		for (String word : inputs) {
			if (word.matches(numericRegex)) {
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
			if (word.matches(numericRegex)) {
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
			if (word.matches(numericRegex)) {
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
			if (word.matches(numericRegex)) {
				result *= Integer.parseInt(word);
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("0번째가 숫자가아닌경우")
	@ValueSource(strings = {"= 2 + 3"})
	void numeric_exception_test(String input) {
		assertThatExceptionOfType(NumberFormatException.class)
				.isThrownBy(() -> {
					List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
					List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

					int result = Integer.parseInt(inputSplitedByBlank.get(0));
				}).withMessageMatching("For input string: \".\"");

	}

	@Test
	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
	void illegalArgumentException_test() {
		List<String> params = new ArrayList<>();

		params.add("");
		params.add(null);

		assertAll(
				() -> assertThatExceptionOfType(IllegalArgumentException.class)
						.isThrownBy(() -> {
							if (params.get(0) == null || "".equals(params.get(0))) {
								throw new IllegalArgumentException("정상적인 사용자 값이 아닙니다.");
							}
						}).withMessageMatching("정상적인 사용자 값이 아닙니다."),
				() -> assertThatExceptionOfType(IllegalArgumentException.class)
						.isThrownBy(() -> {
							if (params.get(1) == null || "".equals(params.get(1))) {
								throw new IllegalArgumentException("정상적인 사용자 값이 아닙니다.");
							}
						}).withMessageMatching("정상적인 사용자 값이 아닙니다.")
		);
	}

	@ParameterizedTest
	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	@ValueSource(strings = {"1 , 2", "1 : 1"})
	void 사칙연산이_아닌경우_IllegalArgumentException(String input) {
		List<String> list = Arrays.asList(input.split(" "));
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					list.forEach(word -> {
						if (!isNumeric(word) || word == null || "".equals(word) || !isOperation(word)) {
							throw new IllegalArgumentException("정상적인 사용자 값이 아닙니다.");
						}
					});
				}).withMessageMatching("정상적인 사용자 값이 아닙니다.");
	}

	@ParameterizedTest
	@DisplayName("전체 사칙연산")
	@CsvSource(value = {"21 + 1 / 11 * 5=10"}, delimiter = '=')
	void operation(String input, int expected) {

		List<String> inputSplitedByBlank = Arrays.asList(input.split(" "));
		List<String> inputs = inputSplitedByBlank.subList(1, inputSplitedByBlank.size());

		int result = Integer.parseInt(inputSplitedByBlank.get(0));
		String op = "";
		for (String word : inputs) {
			if (word.matches(numericRegex)) {
				result = Operation.getResult(result, Integer.parseInt(word), op);
			} else if (word.matches(operationRegex)) {
				op = word;
			}
		}

		assertThat(result).isEqualTo(expected);
	}

	public boolean isOperation(String word) {
		return word.matches(operationRegex);
	}

	public boolean isNumeric(String word) {
		return word.matches(numericRegex);
	}
}
