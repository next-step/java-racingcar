package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculator {

	@Test
	void inputCheck() {
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

	@ParameterizedTest
	@CsvSource(value = {"5+2, 5, 2", "16-5, 16, 5", "4*3, 4, 3", "12/5, 12, 5"})
	void splitString(String param, String result1, String result2) {
		assertThat(param.split("\\+|-|\\*|/")).containsExactly(result1, result2);
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