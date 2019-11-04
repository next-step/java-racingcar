package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator {

	@ParameterizedTest
	@CsvSource(value = {"1+2:3", "4+5:9"}, delimiter = ':')
	void plus(String param, int result) {
		String[] operands = param.split("\\+");
		int left = Integer.parseInt(operands[0]);
		int right = Integer.parseInt(operands[1]);
		assertThat(left + right).isEqualTo(result);
	}

}