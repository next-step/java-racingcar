package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
	@Test
	void stringTest1() {
		String inputString = "1,2";
		String[] result = inputString.split(",");
		assertThat(result).containsExactly("1", "2");

		inputString = "1";
		result = inputString.split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	void stringTest2() {
		String inputString = "(1,2)";
		String[] result = inputString.substring(1, inputString.length() -1).split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("주어진 문자열 abc에 String 클래스의 chartAt()로 특정 위치의 문자를 가져올 때 " +
			"위치 값을 벗어나면 IndexOutOfBoundsException 예외를 던진다")
	@Test
	void stringTest3() {
		String inputString = "abc";
		final int OUT_OF_INDEX = inputString.length() + 1;
		assertThatThrownBy(() -> {
			char c = inputString.charAt(OUT_OF_INDEX);
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("String index out of range: " + OUT_OF_INDEX);
	}
}
