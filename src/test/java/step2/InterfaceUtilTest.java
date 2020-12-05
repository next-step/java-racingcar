package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InterfaceUtil : 입력값을 검증할 수 있는 클래스")
class InterfaceUtilTest {

	@DisplayName("parseInput : 계산하기 올바른 input 조건을 만족하면 공백을 기준으로 split한 배열을 리턴함")
	@Test
	void parseInput_shouldPass() {
		String[] result = InterfaceUtil.parseInput("2 + 3 * 4");
		assertThat(result)
			.containsExactly("2", "+", "3", "*", "4");
	}

	@DisplayName("parseInput : 계산하기 올바른 input 조건이 아니어 예외 발생")
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {"2 + 3 * 4 /", "2 +3", "+ 3 * 44", "a * 44"})
	void parseInput_shouldPass(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> InterfaceUtil.parseInput(input));
	}

	@DisplayName("checkEmpty : null 혹은 공백이면 에러가 발생함")
	@ParameterizedTest
	@NullSource
	@EmptySource
	void checkEmpty(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> InterfaceUtil.checkEmpty(input));
	}

	@DisplayName("checkCorrectCharacter : 계산하기에 올바른 input 조건을 만족함")
	@ParameterizedTest
	@ValueSource(strings = {"2 + 3 * 4 / 2", "2 + 3", "2 + 3 * 44"})
	void checkCorrectCharacter_shouldPass(String input) {
		InterfaceUtil.checkCorrectCharacter(input);
	}

	@DisplayName("checkCorrectCharacter : 계산하기에 올바른 input이 아니어 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"2 + 3 * 4 /", "2 ++ 3", "+ 3 * 44", "a * 44"})
	void checkCorrectCharacter_shouldException(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> InterfaceUtil.checkCorrectCharacter(input));
	}

	@DisplayName("matchRegExpOrException : 입력된 문자열이 정규식을 만족함")
	@ParameterizedTest
	@CsvSource(value = {"[0-9]+,123", "[0-9]+,64", "[*+/-],-", "[*+/-],+"})
	void matchRegExpOrException_shouldPass(String regExp, String input) {
		InterfaceUtil.matchRegExpOrException(regExp, input);
	}

	@DisplayName("matchRegExpOrException : 입력된 문자열이 정규식을 만족하지 않아 예외 발생")
	@ParameterizedTest
	@CsvSource(value = {"[0-9]+,a", "[0-9]+,b", "[*+/-],%", "[*+/-],--"})
	void matchRegExpOrException_shouldException(String regExp, String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> InterfaceUtil.matchRegExpOrException(regExp, input));
	}
}