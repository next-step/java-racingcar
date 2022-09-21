package racingcar.step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

	@DisplayName("String 클래스의 split() 메서드 활용1")
	@Test
	void splitNumbers() {
		String numbers = "1,2";

		String[] result = numbers.split(",");

		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("String 클래스의 split() 메서드 활용2")
	@Test
	void splitNumber() {
		String number = "1";

		String[] result = number.split(",");

		assertThat(result).containsExactly("1");
	}

	@DisplayName("String 클래스의 substring() 메서드 활용")
	@Test
	void substring() {
		String value = "(1,2)";
		final int beginIndex = 1;
		final int endIndex = value.length() - 1;

		String result = value.substring(beginIndex, endIndex);

		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("charAt() 메서드 활용")
	@Test
	void charAt() {
		String value = "abc";

		assertThatThrownBy(() -> value.charAt(value.length())).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");
	}
}
