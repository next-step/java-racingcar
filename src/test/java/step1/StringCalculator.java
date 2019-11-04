package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

	@ParameterizedTest
	@CsvSource(value = {"1 + 2:1+2", "5- 4:5-4"}, delimiter = ':')
	void removeSpaceChar(String param, String result) {
		param = param.replaceAll(" ", "");
		assertThat(param).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"1+2:3", "4+5:9"}, delimiter = ':')
	void plus(String param, int result) {
		param = param.replaceAll(" ", "");
		String[] operands = param.split("\\+");
		int left = Integer.parseInt(operands[0]);
		int right = Integer.parseInt(operands[1]);
		assertThat(left + right).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"5-2:3", "13 -3:10"}, delimiter = ':')
	void minus(String param, int result) {
		param = param.replaceAll(" ", "");
		String[] operands = param.split("-");
		int left = Integer.parseInt(operands[0]);
		int right = Integer.parseInt(operands[1]);
		assertThat(left - right).isEqualTo(result);
	}

	@ParameterizedTest
	@CsvSource(value = {"7 * 4:28", "21 *3:63"}, delimiter = ':')
	void multiply(String param, int result) {
		param = param.replaceAll(" ", "");
		String[] operands = param.split("\\*");
		int left = Integer.parseInt(operands[0]);
		int right = Integer.parseInt(operands[1]);
		assertThat(left * right).isEqualTo(result);
	}

}