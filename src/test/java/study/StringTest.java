package study;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void 요구사항1_1() {
		String input = "1,2";

		String[] split = input.split(",");

		assertThat(split).contains("1");
		assertThat(split).contains("2");
	}

	@Test
	void 요구사항1_2() {
		String input = "1";
		String[] split = input.split(",");
		assertThat(split).containsExactly("1");
	}

	@Test
	void 요구사항2() {
		String input = "(1,2)";
		String substring = input.substring(1, input.length() -1);
		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	@DisplayName("주어진 값의 특정 위치에 있는 값을 리턴하고, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
	void 요구사항3() {
		assertThatThrownBy(() -> {
			String input = "abc";
			input.charAt(4);
		}).isInstanceOf(StringIndexOutOfBoundsException.class);
	}

	@Test
	@DisplayName("주어진 값의 특정 위치에 있는 값을 리턴하고, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다")
	void 요구사항3_2() {
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				String input = "abc";
				input.charAt(4);
			});
	}
}
