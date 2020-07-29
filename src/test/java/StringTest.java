import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringTest {

	@DisplayName("구분자를 기준으로 문자열분리")
	@ParameterizedTest
	@CsvSource(value = {"1,2:2", "1:1"}, delimiter = ':')
	void split(String value, int length) {
		//when
		String[] actual = value.split(",");

		//then
		assertEquals(length, actual.length);
	}

	@DisplayName("괄화를 제외한 값 추출")
	@Test
	void replace() {
		String value = "(1,2)";

		//when
		String actual = value.replace("(", "").replace(")", "");

		//then
		assertEquals("1,2", actual);
	}

	@DisplayName("잘못된 index 입력시 OutOfBoundIndex 예외발생")
	@Test
	void charAtWithOutOfBoundException() {
		assertThatThrownBy(() -> "123".charAt(4))
				.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
