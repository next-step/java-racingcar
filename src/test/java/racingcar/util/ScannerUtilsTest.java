package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScannerUtilsTest {
	@DisplayName("스캐너를 통하여 int 값을 받는지 검증")
	@ParameterizedTest
	@CsvSource(value = {
		"1, 1",
		"5, 5",
		"9, 9",
	})
	void scanInt(String input, int expected) {
		// given
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		int result = ScannerUtils.scanInt();

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("스캐너를 통하여 String 값을 받는지 검증")
	@ParameterizedTest
	@CsvSource(value = {
		"text, text",
		"string, string",
		"set, set",
	})
	void scanString(String input, String expected) {
		// given
		ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		String result = ScannerUtils.scanString();

		// then
		assertThat(result).isEqualTo(expected);
	}
}
