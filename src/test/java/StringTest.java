import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

	@DisplayName("요구사항 1 - 1,2 분리 확인")
	@Test
	void splitNumber() {
		//given
		String value = "1,2";
		String delimiter = ",";

		//when
		String[] split = value.split(delimiter);

		//then
		assertThat(split.length).isEqualTo(2);
		assertThat(split).containsExactly("1", "2");
	}

	@DisplayName("요구사항 2 - 괄호내부값 반환")
	@ParameterizedTest
	@CsvSource(value = {"(1):1", "(1,2):1,2"}, delimiter = ':')
	void replace(String value, String expect) {
		//when
		String actual = value.replace("(", "").replace(")", "");

		//then
		assertEquals(expect, actual);
	}

	@DisplayName("요구사항 3 - OutOfBoundException 테스트")
	@ParameterizedTest
	@CsvSource(value = {"a,2", "abc,4"})
	void charAt(String value, int index) {
		assertThatThrownBy(() -> value.charAt(index))
				.isInstanceOf(StringIndexOutOfBoundsException.class);;
	}
}
