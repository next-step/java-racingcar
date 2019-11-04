package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculator {

	@Test
	void inputValueCheck() {
		String input = null;
		assertThatThrownBy(() -> {
			if (input == null || input.equals("")) {
				throw new IllegalArgumentException();
			}
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2:1+2", "5- 4:5-4"}, delimiter = ':')
	void removeSpaceChar(String param, String result) {
		param = param.replaceAll(" ", "");
		assertThat(param).isEqualTo(result);
	}

	@Test
	void operatorCheck() {
		char ch = '&';
		assertThatThrownBy(() -> {
			if (ch != '+' && ch != '-' && ch != '*' && ch != '/' ) {
				throw new IllegalArgumentException();
			}
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1+2-3*4/5"})
	void splitInput(String param) {
		assertThat(param.split("")).containsExactly("1", "+", "2", "-", "3", "*", "4", "/", "5");
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3", "9,8,17"})
	void plus(int left, int right, int result) {
		assertThat(left + right).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"5,2,3", "13,3,10"})
	void minus(int left, int right, int result) {
		assertThat(left - right).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"7,4,28", "21,3,63"})
	void multiply(int left, int right, int result) {
		assertThat(left * right).isEqualTo(result);
	}

}